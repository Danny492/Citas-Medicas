package com.citasmedicas_backend.services;

import com.citasmedicas_backend.entities.DoctorEntity;

import java.util.List;

public interface DoctorService {

    List<DoctorEntity> doctors();
    DoctorEntity findDoctorById(Long id);
    DoctorEntity save(DoctorEntity doctor);
    DoctorEntity update(DoctorEntity doctor, Long id);
    void delete(Long id);
}
