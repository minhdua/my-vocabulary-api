package com.minhdua.apps.payload.request;

import javax.validation.constraints.NotBlank;

import com.minhdua.apps.validation.Password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordRequest {
	@NotBlank
	@Password
	private String oldPassword;

	@NotBlank
	@Password
	private String newPassword;

	@NotBlank
	@Password
	private String passwordRetyping;
}