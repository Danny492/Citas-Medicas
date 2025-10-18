package com.citasmedicas_backend.services;

import com.citasmedicas_backend.dtos.DoctorDTO;
import com.citasmedicas_backend.entities.DoctorEntity;

import java.util.List;

public interface DoctorService {

    List<DoctorDTO> doctors();
    DoctorDTO findDoctorById(Long id);
    DoctorDTO save(DoctorDTO doctor);
    DoctorDTO update(DoctorDTO doctor, Long id);
    void delete(Long id);
}
