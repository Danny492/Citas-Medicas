package com.citasmedicas_backend.services;

import com.citasmedicas_backend.dtos.CitaDTO;
import java.util.List;

public interface CitaService {

    List<CitaDTO> citas();
    CitaDTO findById(Long id);
    CitaDTO update(CitaDTO cita, Long id);
    CitaDTO save(CitaDTO cita);
    void delete(Long id);
}
