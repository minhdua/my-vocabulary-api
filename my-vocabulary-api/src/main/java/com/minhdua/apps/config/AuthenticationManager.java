package com.minhdua.apps.config;

import com.minhdua.apps.repository.UserReactiveRepository;
import com.minhdua.apps.util.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserReactiveRepository userReactiveRepository;

	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		var token = authentication.getCredentials().toString();
		var username = jwtUtils.getUsernameFromToken(token);

		return userReactiveRepository.findByUsername(username).flatMap(userDetails -> {
			if (username.equals(userDetails.getUsername()) && jwtUtils.isTokenValidated(token)) {
				return Mono.just(authentication);
			}
			return Mono.empty();
		});
	}

}