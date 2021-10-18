package com.minhdua.apps.config;

import java.util.Collections;

import com.minhdua.apps.repository.UserReactiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@AllArgsConstructor
public class WebFluxSecurityDBConfiguration {
	@Autowired
	private UserReactiveRepository userReactiveRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private SecurityContextRepository securityContextRepository;

	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	ReactiveUserDetailsService userDetailsService() {
		return username -> userReactiveRepository.findByUsername(username)
				.map(user -> User.withUsername(username).password(user.getPassword())
						.authorities(Collections.singletonList("ROLE_USER").toArray(new String[0]))
						.accountExpired(false).accountLocked(false).disabled(false).build());
	}

	@Bean
	public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
		return http
				.authorizeExchange(AuthorizeExchangeSpec -> AuthorizeExchangeSpec.pathMatchers("/api/auth/**")
						.permitAll().anyExchange().authenticated())
				.exceptionHandling()
				.authenticationEntryPoint((response, error) -> Mono
						.fromRunnable(() -> response.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)))
				.accessDeniedHandler((response, error) -> Mono
						.fromRunnable(() -> response.getResponse().setStatusCode(HttpStatus.FORBIDDEN)))
				.and().httpBasic().disable().formLogin().disable().csrf().disable()
				.authenticationManager(authenticationManager).securityContextRepository(securityContextRepository)
				.requestCache().requestCache(NoOpServerRequestCache.getInstance()).and().build();
	}
}