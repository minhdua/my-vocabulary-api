package com.minhdua.apps.service;

import java.util.function.BiFunction;

import com.minhdua.apps.document.BaseEntity;
import com.minhdua.apps.dto.BaseDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Mono;

@Builder
@Data
@AllArgsConstructor
public class AbstractService<E extends BaseEntity, D extends BaseDTO, R extends ReactiveMongoRepository<E, String>>
		implements BaseService<E, D, R> {

	protected R repository;
	protected Class<D> dtoClass;
	protected E entity;

	@Autowired
	ModelMapper modelMapper;

	AbstractService(E entity, Class<D> dto, R repository) {
		this.repository = repository;
		this.dtoClass = dto;
		this.entity = entity;
	}

	@Override
	public R getRepository() {
		return this.repository;
	}

	@Override
	public Class<D> getDtoClass() {
		return this.dtoClass;
	}

	@Override
	public ModelMapper getModelMapper() {
		return this.modelMapper;
	}

	@Override
	public BiFunction<ReactiveMongoRepository<E, String>, E, Mono<E>> getMonoByFunction() {
		return (rp, e) -> rp.findById(e.getId());
	}

}