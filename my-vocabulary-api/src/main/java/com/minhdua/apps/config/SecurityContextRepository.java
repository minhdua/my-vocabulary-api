package com.minhdua.apps.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class SecurityContextRepository implements ServerSecurityContextRepository {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Mono<SecurityContext> load(ServerWebExchange serverWebExchange) {
		String bearer = "Bearer ";
		return Mono.justOrEmpty(serverWebExchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
				.filter(b -> b.startsWith(bearer)).map(subs -> subs.substring(bearer.length()))
				.flatMap(token -> Mono
						.just(new UsernamePasswordAuthenticationToken(token, token,
								Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))))
						.flatMap(auth -> authenticationManager.authenticate(auth).map(SecurityContextImpl::new)));
	}

	@Override
	public Mono<Void> save(ServerWebExchange serverWebExchange, SecurityContext securityContext) {

		return Mono.empty();
	}

}