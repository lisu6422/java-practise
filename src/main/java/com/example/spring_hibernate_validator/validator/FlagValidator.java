package com.example.spring_hibernate_validator.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
	String values();

	String message() default "flag does not exist";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
