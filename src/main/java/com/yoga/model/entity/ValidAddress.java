package com.yoga.model.entity;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@NotNull
@NotBlank
@ReportAsSingleViolation
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAddress {

    String message() default "Address must not be blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
