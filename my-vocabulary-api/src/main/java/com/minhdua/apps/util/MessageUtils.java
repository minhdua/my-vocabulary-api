package com.minhdua.apps.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.minhdua.apps.constant.MessageConstants;

public class MessageUtils {

	public static String get(String msg) {
		return getFromObjects(msg, (Object[]) null);
	}

	public static String get(MessageConstants msg) {
		return getFromObjects(msg, (Object[]) null);
	}

	public static String getFromObjects(String msg, Object... args) {
		if (args != null) {
			return MessageFormat.format(msg, args);
		}
		return msg;
	}

	public static String getFromObjects(MessageConstants msg, Object... args) {
		if (args != null) {
			return MessageFormat.format(msg.getMessage(), args);
		}
		return msg.getMessage();
	}

	public static String getFromClasses(String msg, Class<?>... args) {
		List<String> classNames = new ArrayList<>();
		if (args != null) {
			for (Class<?> arg : args) {
				var name = arg.getSimpleName();
				classNames.add(name);
			}
		}
		var arguments = classNames.toArray(String[]::new);
		return getFromObjects(msg, (Object[]) arguments);
	}

	public static String getFromClasses(MessageConstants msg, Class<?>... args) {
		return getFromClasses(msg.getMessage(), args);
	}
}