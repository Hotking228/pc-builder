package com.hotking.pcbuilder.pcbuild;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BuildCompletenessValidator.class)
public @interface Build {

    String message() default "Несовпадение комплектующих!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
