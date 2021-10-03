package com.minhdua.apps.repository;

import com.minhdua.apps.document.Sentence;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SentenceReactiveRepository extends ReactiveMongoRepository<Sentence, String> {

}