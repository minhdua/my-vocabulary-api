package com.minhdua.apps.constant.enums;

import static com.minhdua.apps.constant.CommonConstants.ADMIN_PASS;
import static com.minhdua.apps.constant.CommonConstants.SYSTEM_PASS;
import static com.minhdua.apps.constant.CommonConstants.SYSTEM_USER_NAME;
import static com.minhdua.apps.constant.CommonConstants.USER_PASS;

import com.minhdua.apps.document.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EUser {
	USER_SYSTEM(User.builder().username(SYSTEM_USER_NAME).password(SYSTEM_PASS).build()),
	ADMIN_0762(User.builder().username("Admin@0762").password(ADMIN_PASS).build()),
	ADMIN_036(User.builder().username("Admin@036").password(ADMIN_PASS).build()),
	ADMIN_198(User.builder().username("Admin@198").password(ADMIN_PASS).build()),
	USER_1606(User.builder().username("User@1606").password(USER_PASS).build()),
	USER_980(User.builder().username("User@980").password(USER_PASS).build());

	private User user;
}