package com.minhdua.apps.repository;

import com.minhdua.apps.document.Structure;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StructureReactiveRepository extends ReactiveMongoRepository<Structure,String>{
    
}