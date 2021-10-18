package com.minhdua.apps.constant;

public enum MessageConstants {
	NOT_MATCH("RESOURCE0001F", "{0} didn't match to field {0} confirmation."),
	NOT_FOUND("RESOURCE0002F", "{0} not found."), NOT_FOUND_WITH("RESOURCE0002AF", "{0} not found with {1}."),
	ALREADY_EXISTS("RESOURCE0003F", "{0} already exists."), GET_FAILED("RESOURCE0004F", "Get {0} failed."),
	GET_FAILED_WITH("RESOURCE0004AF", "Get {0} failed."), LIST_FAILED("RESOURCE0005F", "List {0} failed."),
	LIST_FAILED_WITH("RESOURCE0005AF", "List {0} failed with {1}."), SAVE_FAILED("RESOURCE0006F", "Save {0} failed."),
	SAVE_FAILED_EXISTS("RESOURCE0006AF", "Save {0} failed. {1} exists already."),
	UPDATE_FAILED("RESOURCE0007F", "Update {0} failed."),
	UPDATE_FAILED_WITH("RESOURCE0007AF", "Update {0} failed with {1}."),
	UPDATE_FAILED_NOT_FOUND("RESOURCE0007BF", "Update {0} failed. {1} not found."),
	DELETE_FAILED("RESOURCE0008F", "Delete {0} failed}."),
	DELETE_FAILED_WITH("RESOURCE0008AF", "Delete {0} failed with {1}."),
	ACCOUNT_OR_PASSWORD_WRONG("AUTH0009F", "account or password wrong."),
	AUTHENTICATION_FAILED("AUTH0010F", "Authentication Failed"), GET_SUCCESS("RESOURCE0001S", "Get {0} success."),
	LIST_SUCCESS("RESOURCE0002S", "List {0} success."), SAVE_SUCCESS("RESOURCE0003S", "Save {0} success."),
	UPDATE_SUCCESS("RESOURCE0004S", "Update {0} success."),
	AUTHENTICATION_SUCCESSFUL("AUTH0001S", "Authentication successful."),
	REGISTRATION_SUCCESSFUL("AUTH0002S", "New user register success.");
	String code;
	String message;

	MessageConstants(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}