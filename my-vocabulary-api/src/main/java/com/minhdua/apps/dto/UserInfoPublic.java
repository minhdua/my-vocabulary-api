package com.minhdua.apps.dto;

import java.util.Set;

import com.minhdua.apps.document.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoPublic extends BaseDto {
	private String username;
	private String firstName;
	private String lastName;
	private String photo;
	protected Set<Role> roles;
}