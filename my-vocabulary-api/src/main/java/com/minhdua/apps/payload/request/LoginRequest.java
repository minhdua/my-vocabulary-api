package com.minhdua.apps.payload.request;

import javax.validation.constraints.NotBlank;

import com.minhdua.apps.validation.Password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	@NotBlank
	private String username;

	@NotBlank(message = "Not null")
	@Password
	private String password;
}
