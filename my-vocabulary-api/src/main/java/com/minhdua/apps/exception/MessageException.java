package com.minhdua.apps.exception;

import static com.minhdua.apps.util.MessageUtils.getFromObjects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.minhdua.apps.constant.MessageConstants;
import com.minhdua.apps.util.MessageUtils;

public interface MessageException<E extends Throwable> {

	MessageConstants getMessageConstants();

	String getGenericName();

	@SuppressWarnings("unchecked")
	default E createInstant(String messageCode, String message) {
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			Class<E> aClass = (Class<E>) classLoader.loadClass(getGenericName());
			Constructor<E> constr1 = aClass.getConstructor(String.class, String.class);
			return (E) constr1.newInstance(messageCode, message);
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	default E withMessageConstant(MessageConstants msgConstants, String... args) {
		var message = MessageUtils.getFromObjects(msgConstants, (Object[]) args);
		return createInstant(msgConstants.getCode(), message);
	}

	default E withMessageConstant(MessageConstants msgConstants, Class<?>... args) {
		var message = MessageUtils.getFromClasses(msgConstants, args);
		return createInstant(msgConstants.getCode(), message);
	}

	default E withParam(Class<?>... args) {
		var messageConstants = getMessageConstants();
		var message = MessageUtils.getFromClasses(messageConstants, args);
		return createInstant(messageConstants.getCode(), message);
	}

	default E withParam(String... args) {
		var messageConstants = getMessageConstants();
		var message = MessageUtils.getFromObjects(messageConstants, (Object[]) args);
		return createInstant(messageConstants.getCode(), message);
	}

	default E withDefault() {
		return createInstant(getMessageConstants().getCode(), getMessageDefault());
	}

	default String getMessageDefault() {
		var messageConstants = getMessageConstants();
		return getFromObjects(messageConstants, "Resource");
	}

}