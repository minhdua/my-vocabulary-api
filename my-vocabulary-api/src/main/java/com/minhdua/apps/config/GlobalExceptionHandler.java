package com.minhdua.apps.config;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {

	public GlobalExceptionHandler(ErrorAttributes errorAttributes, Resources resources,
			ApplicationContext applicationContext, ServerCodecConfigurer codecConfigurer) {
		super(errorAttributes, resources, applicationContext);
		this.setMessageWriters(codecConfigurer.getWriters());
	}

	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
	}

	private Mono<ServerResponse> formatErrorResponse(ServerRequest request) {
		Map<String, Object> errorAttributesMap = getErrorAttributes(request, ErrorAttributeOptions.defaults());
		var status = (int) Optional.ofNullable(errorAttributesMap.get("status")).orElse(500);
		var httpStatus = HttpStatus.valueOf(status);

		return ServerResponse.status(httpStatus).contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(errorAttributesMap));
	}

}