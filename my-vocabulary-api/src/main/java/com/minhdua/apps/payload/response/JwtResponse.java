package com.minhdua.apps.payload.response;

import com.minhdua.apps.dto.UserInfoPublic;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JwtResponse extends ResultResponse<UserInfoPublic> {
	private String token;
	@Default
	private String type = "Bearer ";
}
