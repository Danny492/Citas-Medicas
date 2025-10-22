package com.citasmedicas_backend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CedulaValidator implements ConstraintValidator<Cedula, String> {

    @Override
    public boolean isValid(String cedula, ConstraintValidatorContext constraintValidatorContext) {
        // Eliminar guiones y espacios en blanco
        cedula = cedula.replace("-", "").trim();

        // La cédula debe tener 11 dígitos
        if (cedula.length() != 11) {
            return false;
        }

        // La cédula debe contener solo dígitos
        if (!cedula.matches("\\d{11}")) {
            return false;
        }

        // Validar el dígito de control
        int sumatoria = 0;
        int[] coeficientes = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

        for (int i = 0; i < 10; i++) {
            int digito = Integer.parseInt(String.valueOf(cedula.charAt(i)));
            int resultado = digito * coeficientes[i];

            // Si el resultado es de dos dígitos, se suman sus componentes
            if (resultado >= 10) {
                resultado = (resultado / 10) + (resultado % 10);
            }
            sumatoria += resultado;
        }

        int digitoVerificador = (10 - (sumatoria % 10)) % 10;
        int ultimoDigitoCedula = Integer.parseInt(String.valueOf(cedula.charAt(10)));

        return digitoVerificador == ultimoDigitoCedula;
    }

}
