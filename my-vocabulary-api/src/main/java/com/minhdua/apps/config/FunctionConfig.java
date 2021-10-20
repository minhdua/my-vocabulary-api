package com.minhdua.apps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class FunctionConfig {

	@Autowired
	public ValidationComponent validator;

	public <T> Mono<ServerResponse> process(T data) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data);
	}
}