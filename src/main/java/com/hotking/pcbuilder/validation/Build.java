package com.hotking.pcbuilder.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = BuildCompletenessValidator.class)
public @interface Build {

    String message() default "Имя или фамилия должны быть введены!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
