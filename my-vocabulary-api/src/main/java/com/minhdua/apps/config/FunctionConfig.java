package com.minhdua.apps.config;

import com.minhdua.apps.exception.ServerException;
import com.minhdua.apps.payload.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class FunctionConfig {

	public <T> Mono<ServerResponse> process(Mono<T> mono) {
		return mono.flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data))
				.onErrorResume(error -> {
					var messageCode = "SYSTEMS0001F";
					if (error instanceof ServerException) {
						var err = (ServerException) error;
						messageCode = err.getMessageCode();
					}
					var errorResponse = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST)
							.message(error.getMessage()).messageCode(messageCode)
							.exceptionClass(error.getClass().getSimpleName()).build();
					return ServerResponse.badRequest().bodyValue(errorResponse);
				});
	}
}