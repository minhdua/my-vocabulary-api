package com.minhdua.apps.config;

import com.minhdua.apps.constant.enums.EUser;
import com.minhdua.apps.document.User;
import com.minhdua.apps.repository.UserReactiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;

import reactor.core.publisher.Mono;

@Configuration
public class SecurityAuditorAware {

	@Autowired
	UserReactiveRepository userRepository;

	@Bean
	public ReactiveAuditorAware<User> getCurrentAuditor() {
		return () -> ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
				.filter(Authentication::isAuthenticated).map(Authentication::getPrincipal).map(UserDetails.class::cast)
				.map(UserDetails::getUsername).flatMap(username -> {
					return userRepository.findByUsername(username);
				}).switchIfEmpty(Mono.defer(() -> {
					var userDefault = EUser.USER_SYSTEM.getUser();
					var username = userDefault.getUsername();
					return userRepository.findByUsername(username).switchIfEmpty(Mono.empty());
				}));
	}

}