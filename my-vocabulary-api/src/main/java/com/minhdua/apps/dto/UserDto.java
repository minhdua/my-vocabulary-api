package com.minhdua.apps.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.minhdua.apps.document.Profile;
import com.minhdua.apps.document.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
	private String username;
	private Profile profile;
	private Boolean isEnabled;
	private Boolean isCredentialsNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isAccountNonExpired;
	protected Set<Role> roles;
	private LocalDateTime lastLoginDate;
}