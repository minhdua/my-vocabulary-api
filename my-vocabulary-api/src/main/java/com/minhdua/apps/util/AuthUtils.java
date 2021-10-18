package com.minhdua.apps.util;

import com.minhdua.apps.constant.enums.ERole;
import com.minhdua.apps.constant.enums.EUser;
import com.minhdua.apps.document.Profile;
import com.minhdua.apps.document.Role;
import com.minhdua.apps.document.User;
import com.minhdua.apps.repository.RoleReactiveRepository;
import com.minhdua.apps.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class AuthUtils {

	@Autowired
	RoleService roleService;
	@Autowired
	RoleReactiveRepository roleRepository;

	public static String bCryptEncoder(String key) {
		var encoder = new BCryptPasswordEncoder();
		return encoder.encode(key);
	}

	public Mono<User> userDefault(String username, String password) {
		var userDefault = User.builder().username(username).password(bCryptEncoder(password))
				.passwordRetyping(bCryptEncoder(password)).profile(new Profile()).build();
		return Mono.just(userDefault).flatMap(user -> {
			var userRole = ERole.USER_ROLE.getRole();
			return setRole(userRole, user);
		}).flatMap(this::setRole);
	}

	private Mono<User> setRole(Role role, User user) {
		return roleRepository.findByFullName(role.getFullName()).defaultIfEmpty(role).flatMap(iRole -> {
			if (iRole.getId() == null) {
				iRole.setId(UuidUtils.uuid());
				return roleRepository.save(iRole).map(r -> {
					user.getRoles().add(r);
					return user;
				});
			}
			user.getRoles().add(iRole);
			return Mono.just(user);
		});
	}

	private Role checkRole(String username) {
		if (username.startsWith("Admin")) {
			return ERole.ADMIN_ROLE.getRole();
		}
		if (username.startsWith("System")) {
			return ERole.SYSTEM_ROLE.getRole();
		}
		return null;
	}

	private Mono<User> setRole(User user) {
		var username = user.getUsername();
		Role role = checkRole(username);
		if (inEUser(username) && role != null) {
			return setRole(role, user);
		}
		return Mono.just(user);
	}

	private boolean inEUser(String username) {
		for (EUser us : EUser.values()) {
			if (us.getUser().getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

}