package com.minhdua.apps.repository;

import com.minhdua.apps.document.Language;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface LanguageReactiveRepository extends ReactiveMongoRepository<Language, String> {
	Mono<Language> findByFullName(String fullName);
	Mono<Language> findByShortName(String shortName);
}