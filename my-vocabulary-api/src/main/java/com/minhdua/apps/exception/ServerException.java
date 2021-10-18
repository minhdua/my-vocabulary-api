package com.minhdua.apps.exception;

import lombok.Data;

@Data
public class ServerException extends RuntimeException {

	private String messageCode;
	private String message;

	protected ServerException() {
		super();
	}

	protected ServerException(String message) {
		super(message);
	}

	protected ServerException(Throwable cause) {
		super(cause);
	}

	protected ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	protected ServerException(String messageCode, String message) {
		this.messageCode = messageCode;
		this.message = message;
	}

}