package com.minhdua.apps.payload.request;

import javax.validation.constraints.NotBlank;

import com.minhdua.apps.validation.Password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
	@NotBlank
	private String username;

	@Password
	@NotBlank
	private String password;

	@Password
	@NotBlank
	private String passwordRetyping;
}
