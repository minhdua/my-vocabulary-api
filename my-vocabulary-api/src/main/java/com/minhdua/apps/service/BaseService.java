package com.minhdua.apps.service;

import java.util.function.BiFunction;

import com.minhdua.apps.document.BaseEntity;
import com.minhdua.apps.dto.BaseDTO;
import com.minhdua.apps.exception.ResourceAlreadyExistsException;
import com.minhdua.apps.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface BaseService<E extends BaseEntity, D extends BaseDTO, R extends ReactiveMongoRepository<E, String>> {
	R getRepository();

	Class<D> getDtoClass();

	ModelMapper getModelMapper();

	BiFunction<ReactiveMongoRepository<E, String>, E, Mono<E>> getMonoByFunction();

	default Mono<D> save(E entity) {
		var repository = getRepository();
		var modelMapper = getModelMapper();
		var dto = getDtoClass();
		return repository.save(entity).flatMap(e -> {
			return Mono.just(modelMapper.map(entity, dto));
		});
	}

	default Mono<?> findByIdOrSave(E entity) {
		var repository = getRepository();
		return repository.findById(entity.getId()).flatMap(e -> {
			return Mono.error(ResourceAlreadyExistsException::new);
		}).switchIfEmpty(Mono.defer(() -> save(entity)));
	}

	default Mono<?> findByIdOrUpdate(E entity) {
		var repository = getRepository();
		return repository.findById(entity.getId()).flatMap(e -> {
			return save(entity);
		}).switchIfEmpty(Mono.defer(() -> Mono.error(ResourceNotFoundException::new)));
	}

	default Mono<D> findOneById(String id) {
		var repository = getRepository();
		var modelMapper = getModelMapper();
		var dto = getDtoClass();
		return repository.findById(id).flatMap(e -> {
			return Mono.just(modelMapper.map(e, dto));
		});
	}

	default Mono<D> findOneByIndex(E entity) {
		var repository = getRepository();
		var modelMapper = getModelMapper();
		var dto = getDtoClass();
		var function = getMonoByFunction();
		return function.apply(repository, entity).flatMap(e -> {
			return Mono.just(modelMapper.map(e, dto));
		});
	}

	default Mono<?> findByIndexOrSave(E entity) {
		var repository = getRepository();
		var function = getMonoByFunction();
		return function.apply(repository, entity).flatMap(e -> {
			return Mono.error(ResourceAlreadyExistsException::new);
		}).switchIfEmpty(Mono.defer(() -> save(entity)));
	}

	default Mono<?> findByIndexOrUpdate(E entityOld, E entityNew) {
		var repository = getRepository();
		var function = getMonoByFunction();
		return function.apply(repository, entityOld).flatMap(e -> {
			return save(entityNew);
		}).switchIfEmpty(Mono.defer(() -> Mono.error(ResourceNotFoundException::new)));
	}

	default Mono<Void> deleteOneById(String id) {
		var repository = getRepository();
		return repository.findById(id).flatMap(e -> {
			e.setIsDeleted(Boolean.TRUE);
			return save(e);
		}).then();
	}

	default Flux<D> findAll() {
		var repository = getRepository();
		var modelMapper = getModelMapper();
		var dto = getDtoClass();
		return repository.findAll().flatMap(e -> {
			return Mono.just(modelMapper.map(e, dto));
		});
	}

}