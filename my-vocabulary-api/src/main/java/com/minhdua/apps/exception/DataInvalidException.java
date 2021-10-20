package com.minhdua.apps.exception;

import static com.minhdua.apps.constant.MessageConstants.DATA_INVALID;

import com.minhdua.apps.constant.MessageConstants;

import org.springframework.http.HttpStatus;

public class DataInvalidException extends ServerException implements MessageException<DataInvalidException> {

	@Override
	public MessageConstants getMessageConstants() {
		return DATA_INVALID;
	};

	@Override
	public String getGenericName() {
		return DataInvalidException.class.getName();
	}

	public static DataInvalidException getInstance() {
		return new DataInvalidException();
	}

	public DataInvalidException(HttpStatus status, String messageCode, String message) {
		super(status, messageCode, message);
	}

	public DataInvalidException() {
	}

	public DataInvalidException(String message) {
		super(message);
	}

	public DataInvalidException(Throwable cause) {
		super(cause);
	}

	public DataInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataInvalidException(String messageCode, String message) {
		super(messageCode, message);
	}

}