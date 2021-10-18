package com.minhdua.apps.repository;

import com.minhdua.apps.document.Type;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface TypeReactiveRepository extends ReactiveMongoRepository<Type, String> {
	Mono<Type> findByFullName(String fullName);

	Mono<Type> findByShortName(String shortName);
}
