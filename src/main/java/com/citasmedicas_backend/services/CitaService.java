package com.citasmedicas_backend.services;

import com.citasmedicas_backend.entities.CitaEntity;

import java.util.List;

public interface CitaService {

    List<CitaEntity> citas();
    CitaEntity findById(Long id);
    CitaEntity update(CitaEntity cita, Long id);
    CitaEntity save(CitaEntity cita);
    void delete(Long id);
}
