package com.citasmedicas_backend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefonoValidator implements ConstraintValidator<Telefono, String> {

    @Override
    public boolean isValid(String t, ConstraintValidatorContext constraintValidatorContext) {
        t = t.replace("-","").trim();

        if (!t.matches("\\d{10}")) {
            return false;
        }

        return  t.matches("^[0-9]{10,15}$");
    }
}
