package com.citasmedicas_backend.dtos;

import com.citasmedicas_backend.entities.Enums.EstadoCitaEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CitaDTO {

    private Long id;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 255, message = "La descripción debe tener entre 5 y 255 caracteres")
    private String descripcion;

    @NotNull(message = "La fecha y hora de la cita son obligatorias")
    @FutureOrPresent(message = "La fecha y hora deben ser actuales o futuras")
    private LocalDateTime fechaHora;

    @NotNull(message = "El estado de la cita es obligatorio")
    @Enumerated(EnumType.STRING)
    private EstadoCitaEnum estado;

    @NotNull(message = "Debe especificarse el ID del doctor")
    @Positive(message = "El ID del doctor debe ser un número positivo")
    private Long doctorId;

    @NotNull(message = "Debe especificarse el ID del paciente")
    @Positive(message = "El ID del paciente debe ser un número positivo")
    private Long pacienteId;
}
