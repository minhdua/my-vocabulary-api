package com.minhdua.apps.repository;

import com.minhdua.apps.document.Type;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TypeReactiveRepository extends ReactiveMongoRepository<Type,String>{
	
}
