package com.minhdua.apps.repository;

import com.minhdua.apps.document.Language;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LanguageReactiveRepository extends ReactiveMongoRepository<Language,String>{
    
}