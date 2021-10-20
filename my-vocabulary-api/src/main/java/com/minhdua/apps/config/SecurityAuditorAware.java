package com.minhdua.apps.config;

import com.minhdua.apps.document.User;
import com.minhdua.apps.util.AuthUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;

@Configuration
public class SecurityAuditorAware {

	@Bean
	public ReactiveAuditorAware<User> getCurrentAuditor(@Autowired AuthUtils authUtils) {
		return authUtils::getSecurityContextHolderUser;
	}

}