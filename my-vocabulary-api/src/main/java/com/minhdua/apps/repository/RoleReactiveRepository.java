package com.minhdua.apps.repository;

import com.minhdua.apps.document.Role;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoleReactiveRepository extends ReactiveMongoRepository<Role, String> {

}
