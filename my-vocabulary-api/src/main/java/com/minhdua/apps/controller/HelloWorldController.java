package com.minhdua.apps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public Mono<String> helloWorld() {
		return Mono.just("hello");
	}
}