package com.minhdua.apps.functions;

import com.minhdua.apps.config.FunctionConfig;
import com.minhdua.apps.payload.request.LoginRequest;
import com.minhdua.apps.payload.request.SignupRequest;
import com.minhdua.apps.repository.UserReactiveRepository;
import com.minhdua.apps.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
		var body = serverRequest.bodyToMono(LoginRequest.class);
		var result = body.flatMap(authService::getToken);
		return process(result);
	}

	public Mono<ServerResponse> register(ServerRequest request) {
		var body = request.bodyToMono(SignupRequest.class);
		var result = body.flatMap(authService::signup);
		return process(result);
	}

	public Mono<ServerResponse> hello(ServerRequest request) {
		return authService.hello()
				.flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data));
	}
}
