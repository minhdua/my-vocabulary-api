package com.minhdua.apps.constant.enums;

import com.minhdua.apps.document.User;
import com.minhdua.apps.util.JwtUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EUser {
	USER_SYSTEM(User.builder().username("systemUser").password(JwtUtils.bCryptEncoder("metSys@123456")).build());
	private User user;
}