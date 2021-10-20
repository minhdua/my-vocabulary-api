package com.minhdua.apps.functions;

import com.minhdua.apps.config.FunctionConfig;
import com.minhdua.apps.payload.request.LoginRequest;
import com.minhdua.apps.payload.request.SignupRequest;
import com.minhdua.apps.repository.UserReactiveRepository;
import com.minhdua.apps.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class AuthFunctions extends FunctionConfig {

	@Autowired
	UserReactiveRepository userRepository;

	@Autowired
	AuthService authService;

	@Autowired
	PasswordEncoder encoder;

	public Mono<ServerResponse> getToken(ServerRequest serverRequest) {
		return serverRequest.bodyToMono(LoginRequest.class).flatMap(payload -> {
			return validator.validate(payload).flatMap(authService::getToken).flatMap(this::process);
		});
	}

	public Mono<ServerResponse> register(ServerRequest serverRequest) {
		return serverRequest.bodyToMono(SignupRequest.class).flatMap(payload -> {
			return validator.validate(payload).flatMap(authService::signup).flatMap(this::process);
		});
	}

	public Mono<ServerResponse> profile(ServerRequest request) {
		return authService.profile().flatMap(this::process);
	}
}
