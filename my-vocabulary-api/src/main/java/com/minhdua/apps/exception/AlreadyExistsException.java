package com.minhdua.apps.exception;

import static com.minhdua.apps.constant.MessageConstants.ALREADY_EXISTS;

import com.minhdua.apps.constant.MessageConstants;

public class AlreadyExistsException extends ServerException implements MessageException<AlreadyExistsException> {

	@Override
	public MessageConstants getMessageConstants() {
		return ALREADY_EXISTS;
	}

	public AlreadyExistsException() {
		super();
	}

	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyExistsException(String message) {
		super(message);
	}

	public AlreadyExistsException(String messageCode, String message) {
		super(messageCode, message);
	}

	public static AlreadyExistsException getInstance() {
		return new AlreadyExistsException();
	}

	@Override
	public String getGenericName() {
		return AlreadyExistsException.class.getName();
	}
}