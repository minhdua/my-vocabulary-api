package com.minhdua.apps.exception;

import static com.minhdua.apps.constant.MessageConstants.NOT_MATCH;

import com.minhdua.apps.constant.MessageConstants;

public class NotMatchException extends ServerException implements MessageException<NotMatchException> {

	public NotMatchException() {
		super();
	}

	public NotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotMatchException(String message) {
		super(message);
	}

	public NotMatchException(String messageCode, String message) {
		super(messageCode, message);
	}

	@Override
	public MessageConstants getMessageConstants() {
		return NOT_MATCH;
	}

	public static NotMatchException getInstance() {
		return new NotMatchException();
	}

	@Override
	public String getGenericName() {
		return NotMatchException.class.getName();
	}

}