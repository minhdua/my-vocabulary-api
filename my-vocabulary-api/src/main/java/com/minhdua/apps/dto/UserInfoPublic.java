package com.minhdua.apps.dto;

import java.util.List;

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
	protected List<String> roles;
}