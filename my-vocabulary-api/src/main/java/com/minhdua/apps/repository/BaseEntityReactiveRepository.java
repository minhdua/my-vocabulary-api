package com.minhdua.apps.repository;

import java.util.UUID;

import com.minhdua.apps.model.BaseEntity;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class BaseEntityReactiveRepository {
	public Mono<BaseEntity> getEntity() {
		return Mono.just(BaseEntity.builder().id(UUID.randomUUID().toString()).build());
	}
}