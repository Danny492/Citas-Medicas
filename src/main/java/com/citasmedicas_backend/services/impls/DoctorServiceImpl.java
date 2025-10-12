package com.citasmedicas_backend.services.impls;

import com.citasmedicas_backend.entities.DoctorEntity;
import com.citasmedicas_backend.repositories.DoctorRepository;
import com.citasmedicas_backend.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorEntity> doctors() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorEntity findDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public DoctorEntity save(DoctorEntity doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public DoctorEntity update(DoctorEntity doctor, Long id) {
        DoctorEntity updatedDoctor = findDoctorById(id);
        updatedDoctor.setId(id);
        updatedDoctor.setNombre(doctor.getNombre());
        updatedDoctor.setEspecialidad(doctor.getEspecialidad());
        updatedDoctor.setTelefono(doctor.getTelefono());
        updatedDoctor.setPrecioConsulta(doctor.getPrecioConsulta());
        return save(updatedDoctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
