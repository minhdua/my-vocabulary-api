package com.minhdua.apps.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServerException extends RuntimeException {

	private String messageCode;
	private String message;
	private HttpStatus status = HttpStatus.BAD_REQUEST;

	public ServerException() {
		super();
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable cause) {
		super(cause);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(String messageCode, String message) {
		this.messageCode = messageCode;
		this.message = message;
	}

	public ServerException(HttpStatus status, String messageCode, String message) {
		this.messageCode = messageCode;
		this.message = message;
		this.status = status;
	}
}