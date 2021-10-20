package com.minhdua.apps.config;

import java.util.HashMap;

import javax.validation.Validator;

import com.minhdua.apps.exception.DataInvalidException;
import com.minhdua.apps.exception.PayloadNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class ValidationComponent {

	@Autowired
	Validator validator;

	@Autowired
	ObjectMapperComponent mapper;

	public <T> Mono<T> validate(T payload) {
		if (payload == null)
			return Mono.error(PayloadNotFoundException.getInstance().withDefault());
		var result = validator.validate(payload);
		if (result.isEmpty())
			return Mono.just(payload);
		var errors = new HashMap<String, String>();
		result.forEach(e -> {
			errors.put(e.getPropertyPath().toString(), e.getMessage());
		});
		var message = mapper.toJson(errors);
		return Mono.error(DataInvalidException.getInstance().withMessage(message));
	}
}