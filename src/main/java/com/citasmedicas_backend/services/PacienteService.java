package com.citasmedicas_backend.services;

import com.citasmedicas_backend.entities.PacienteEntity;

import java.util.List;

public interface PacienteService {

    List<PacienteEntity> findAll();
    PacienteEntity findById(Long id);
    PacienteEntity save(PacienteEntity paciente);
    PacienteEntity update(PacienteEntity paciente, Long id);
    void delete(Long id);
}
