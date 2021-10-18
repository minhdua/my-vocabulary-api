package com.minhdua.apps.util;

import java.math.BigInteger;
import java.util.UUID;

public class UuidUtils {

	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	public static String uuidShort() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String uuidNumber() {
		return String.format("%07d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
	}
}