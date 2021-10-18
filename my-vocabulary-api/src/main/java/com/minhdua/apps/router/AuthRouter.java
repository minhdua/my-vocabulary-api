package com.minhdua.apps.router;

import com.minhdua.apps.functions.AuthFunctions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AuthRouter {
	@Bean
	public RouterFunction<ServerResponse> root(AuthFunctions authFunctions) {
		return RouterFunctions.route().POST("api/auth/token", authFunctions::getToken)
				.POST("api/auth/signup", authFunctions::register)
				.GET("api/auth/hello", authFunctions::hello).build();

	}
}