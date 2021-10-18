package com.minhdua.apps.repository;

import com.minhdua.apps.document.Language;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageReactiveRepository extends ReactiveMongoRepository<Language, String> {

}