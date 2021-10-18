package com.minhdua.apps.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.minhdua.apps.document.Profile;

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
	protected List<String> roles;
	private LocalDateTime lastLoginDate;
}