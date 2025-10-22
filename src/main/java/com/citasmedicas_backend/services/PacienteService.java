package com.citasmedicas_backend.services;

import com.citasmedicas_backend.dtos.PacienteDTO;
import com.citasmedicas_backend.entities.PacienteEntity;

import java.util.List;

public interface PacienteService {

    List<PacienteDTO> findAll();
    PacienteDTO findById(Long id);
    PacienteDTO save(PacienteDTO paciente);
    PacienteDTO update(PacienteDTO paciente, Long id);
    void delete(Long id);
}
