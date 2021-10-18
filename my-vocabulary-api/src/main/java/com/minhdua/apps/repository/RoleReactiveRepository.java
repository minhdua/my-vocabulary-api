package com.minhdua.apps.repository;

import com.minhdua.apps.document.Role;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface RoleReactiveRepository extends ReactiveMongoRepository<Role, String> {
	Mono<Role> findByFullName(String fullName);

	Mono<Role> findByShortName(String shortName);
}
