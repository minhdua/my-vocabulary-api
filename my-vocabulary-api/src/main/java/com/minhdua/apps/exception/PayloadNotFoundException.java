package com.minhdua.apps.exception;

import static com.minhdua.apps.constant.MessageConstants.PAYLOAD_NOT_FOUND;

import com.minhdua.apps.constant.MessageConstants;

import org.springframework.http.HttpStatus;

public class PayloadNotFoundException extends ServerException implements MessageException<PayloadNotFoundException> {

	@Override
	public MessageConstants getMessageConstants() {
		return PAYLOAD_NOT_FOUND;
	};

	@Override
	public String getGenericName() {
		return PayloadNotFoundException.class.getName();
	}

	public static PayloadNotFoundException getInstance() {
		return new PayloadNotFoundException();
	}

	public PayloadNotFoundException(HttpStatus status, String messageCode, String message) {
		super(status, messageCode, message);
	}

	public PayloadNotFoundException() {
	}

	public PayloadNotFoundException(String message) {
		super(message);
	}

	public PayloadNotFoundException(Throwable cause) {
		super(cause);
	}

	public PayloadNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PayloadNotFoundException(String messageCode, String message) {
		super(messageCode, message);
	}

}