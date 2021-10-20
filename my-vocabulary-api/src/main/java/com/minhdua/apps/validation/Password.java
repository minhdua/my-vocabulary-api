package com.minhdua.apps.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { PasswordValidator.class })
@Target({ ElementType.FIELD })

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = Password.List.class)
public @interface Password {
	String message() default "Password must contain at least one digit [0-9].\nPassword must contain at least one lowercase Latin character [a-z].\nPassword must contain at least one uppercase Latin character [A-Z].\nPassword must contain at least one special character like ! @ # & ( ).\nPassword must contain a length of at least 8 characters and a maximum of 20 characters.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		Password[] value();
	}
}