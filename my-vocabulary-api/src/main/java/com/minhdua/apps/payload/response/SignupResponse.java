package com.minhdua.apps.payload.response;

import com.minhdua.apps.dto.UserDto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
// @AllArgsConstructor
// @NoArgsConstructor
@SuperBuilder
public class SignupResponse extends ResultResponse<UserDto> {
}