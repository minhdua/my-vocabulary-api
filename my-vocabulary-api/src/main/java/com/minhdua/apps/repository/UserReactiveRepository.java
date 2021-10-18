package com.minhdua.apps.repository;

import com.minhdua.apps.document.User;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface UserReactiveRepository extends ReactiveMongoRepository<User, String> {
	Mono<User> findByUsername(String username);
}