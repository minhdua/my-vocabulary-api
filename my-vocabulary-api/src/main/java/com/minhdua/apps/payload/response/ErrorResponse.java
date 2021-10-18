package com.minhdua.apps.payload.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ErrorResponse<T> extends ResultResponse<T> {
	private String exceptionClass;
}