package com.minhdua.apps.repository;

import com.minhdua.apps.document.Translation;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TranslationReactiveRepository extends ReactiveMongoRepository<Translation,String>{
	
}
