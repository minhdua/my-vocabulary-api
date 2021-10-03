package com.minhdua.apps.repository;

import com.minhdua.apps.document.Vocabulary;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VocabularyReactiveRepository extends ReactiveMongoRepository<Vocabulary, String> {

}