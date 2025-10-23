package com.citasmedicas_backend.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefonoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefono {

    String message() default "El numero de telefono no es valido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
