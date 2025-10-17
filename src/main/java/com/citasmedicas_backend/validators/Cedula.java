package com.citasmedicas_backend.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CedulaValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Cedula {

    String message() default "Cedula incorrecta: Debe tener solo digitos y estos deben ser 11";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
