package com.minhdua.apps.controller;

import com.minhdua.apps.model.BaseEntity;
import com.minhdua.apps.repository.BaseEntityReactiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {

	@Autowired
	BaseEntityReactiveRepository repository;
	@GetMapping("/hello")
	public Mono<BaseEntity> helloWorld() {
		return repository.getEntity();
	}
}