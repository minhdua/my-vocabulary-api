package com.minhdua.apps.exception;

import static com.minhdua.apps.constant.MessageConstants.ACCOUNT_OR_PASSWORD_WRONG;

import com.minhdua.apps.constant.MessageConstants;

public class AccountOrPasswordWrongException extends ServerException
		implements MessageException<AccountOrPasswordWrongException> {

	@Override
	public MessageConstants getMessageConstants() {
		return ACCOUNT_OR_PASSWORD_WRONG;
	}

	@Override
	public String getGenericName() {
		return AccountOrPasswordWrongException.class.getName();
	}

	public static AccountOrPasswordWrongException getInstance() {
		return new AccountOrPasswordWrongException();
	}

	public AccountOrPasswordWrongException() {
	}

	public AccountOrPasswordWrongException(String message) {
		super(message);
	}

	public AccountOrPasswordWrongException(Throwable cause) {
		super(cause);
	}

	public AccountOrPasswordWrongException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountOrPasswordWrongException(String messageCode, String message) {
		super(messageCode, message);
	}

}