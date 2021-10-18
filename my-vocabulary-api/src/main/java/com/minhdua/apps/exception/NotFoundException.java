package com.minhdua.apps.exception;

import static com.minhdua.apps.constant.MessageConstants.NOT_FOUND;

import com.minhdua.apps.constant.MessageConstants;

public class NotFoundException extends ServerException implements MessageException<NotFoundException> {

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String messageCode, String message) {
		super(messageCode, message);
	}

	@Override
	public MessageConstants getMessageConstants() {
		return NOT_FOUND;
	}

	public static NotFoundException getInstance() {
		return new NotFoundException();
	}

	@Override
	public String getGenericName() {
		return NotFoundException.class.getName();
	}

}