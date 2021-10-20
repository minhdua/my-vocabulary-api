package com.minhdua.apps.config;

import java.util.Date;

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
		return jwtUtils.getClaimsFromToken(token).flatMap(claims -> {
			var username = claims.getSubject();
			var isTokenExpired = claims.getExpiration().before(new Date());
			return userReactiveRepository.findByUsername(username).flatMap(userDetails -> {
				if (username.equals(userDetails.getUsername()) && !isTokenExpired) {
					return Mono.just(authentication);
				}
				return Mono.empty();
			});
		});

	}

}