package com.citasmedicas_backend.dtos;

import com.citasmedicas_backend.validators.Telefono;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;

@Data
@Getter
@Setter
public class DoctorDTO {

    private Long id;
    @NotBlank(message = "Este campo es obligatorio")
    @Size(min = 3, max = 40, message = "El nombre debe tener de 3 a 40 caracteres")
    private String nombre;
    @NotBlank(message = "Este campo es obligatorio")
    @Size(min = 3, max = 50, message = "La especialidad debe estar entre 3 y 50 caracteres")
    private String especialidad;
    @NotBlank(message = "Este campo es requerido")
    @Telefono
    private String telefono;
    @Positive(message = "Debe tener un precio mayor a cero")
    @NotNull(message = "El precio no puede ser null")
    private Double precioConsulta;
}
