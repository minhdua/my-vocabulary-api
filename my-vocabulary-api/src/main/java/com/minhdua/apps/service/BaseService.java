package com.minhdua.apps.service;

import java.lang.reflect.ParameterizedType;
import java.util.function.BiFunction;

import com.minhdua.apps.document.BaseEntity;
import com.minhdua.apps.dto.BaseDto;
import com.minhdua.apps.exception.AlreadyExistsException;
import com.minhdua.apps.exception.NotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public abstract class BaseService<E extends BaseEntity, D extends BaseDto, R extends ReactiveMongoRepository<E, String>> {
	@Autowired
	protected R repository;
	@Autowired
	protected ModelMapper modelMapper;

	public Class<D> getDtoClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		@SuppressWarnings("unchecked")
		Class<D> ret = (Class<D>) parameterizedType.getActualTypeArguments()[1];
		return ret;
	}

	public BiFunction<ReactiveMongoRepository<E, String>, E, Mono<E>> getMonoByFunction() {
		return (rp, e) -> rp.findById(e.getId());
	}

	public Mono<D> save(E entity) {
		return repository.save(entity).flatMap(e -> {
			return Mono.just(modelMapper.map(entity, getDtoClass()));
		});
	}

	public Mono<?> findByIdOrSave(E entity) {
		return repository.findById(entity.getId()).map(e -> modelMapper.map(e, getDtoClass()))
				.switchIfEmpty(Mono.defer(() -> save(entity)));
	}

	public Mono<?> saveOrThrow(E entity) {
		return repository.findById(entity.getId()).flatMap(e -> {
			return Mono.error(AlreadyExistsException::new);
		}).switchIfEmpty(Mono.defer(() -> save(entity)));
	}

	public Mono<?> updateOrThrow(E entity) {
		return repository.findById(entity.getId()).flatMap(e -> {
			return save(entity);
		}).switchIfEmpty(Mono.defer(() -> Mono.error(NotFoundException::new)));
	}

	public Mono<D> findOneById(String id) {
		return repository.findById(id).flatMap(e -> {
			return Mono.just(modelMapper.map(e, getDtoClass()));
		});
	}

	public Mono<D> findOneByIndex(E entity) {
		var function = getMonoByFunction();
		return function.apply(repository, entity).flatMap(e -> {
			return Mono.just(modelMapper.map(e, getDtoClass()));
		});
	}

	public Mono<?> findByIndexOrSave(E entity) {
		var function = getMonoByFunction();
		return function.apply(repository, entity).flatMap(e -> {
			return Mono.error(AlreadyExistsException::new);
		}).switchIfEmpty(Mono.defer(() -> save(entity)));
	}

	public Mono<?> findByIndexOrUpdate(E entityOld, E entityNew) {
		var function = getMonoByFunction();
		return function.apply(repository, entityOld).flatMap(e -> {
			return save(entityNew);
		}).switchIfEmpty(Mono.defer(() -> Mono.error(NotFoundException::new)));
	}

	public Mono<Void> deleteOneById(String id) {
		return repository.findById(id).flatMap(e -> {
			e.setIsDeleted(Boolean.TRUE);
			return save(e);
		}).then();
	}

	public Flux<D> findAll() {
		return repository.findAll().flatMap(e -> {
			return Mono.just(modelMapper.map(e, getDtoClass()));
		});
	}

}