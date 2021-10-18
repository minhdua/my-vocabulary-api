package com.minhdua.apps.constant.enums;

import com.minhdua.apps.document.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ERole {
	USER_ROLE(Role.builder().fullName("USER_ROLE").shortName("USER").build()),
	ADMIN_ROLE(Role.builder().fullName("ADMIN_ROLE").shortName("ADMIN").build()),
	MODERATE_ROLE(Role.builder().fullName("MODERATE_ROLE").shortName("MODERATE").build()),
	SYSTEM_ROLE(Role.builder().fullName("SYSTEM_ROLE").shortName("SYSTEM").build());

	private Role role;
}