package com.minhdua.apps.repository;

import com.minhdua.apps.document.User;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserReactiveRepository extends ReactiveMongoRepository<User,String>{
    
}