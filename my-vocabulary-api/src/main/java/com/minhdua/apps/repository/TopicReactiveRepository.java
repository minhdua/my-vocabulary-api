package com.minhdua.apps.repository;

import com.minhdua.apps.document.Topic;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TopicReactiveRepository extends ReactiveMongoRepository<Topic,String>{
	
}
