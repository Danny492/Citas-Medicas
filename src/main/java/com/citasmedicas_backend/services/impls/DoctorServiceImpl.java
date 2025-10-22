package com.citasmedicas_backend.services.impls;

import com.citasmedicas_backend.dtos.DoctorDTO;
import com.citasmedicas_backend.entities.DoctorEntity;
import com.citasmedicas_backend.mappers.DoctorMapper;
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
    public List<DoctorDTO> doctors() {
        return DoctorMapper.INSTANCE.toDTO(doctorRepository.findAll());
    }

    @Override
    public DoctorDTO findDoctorById(Long id) {
        return DoctorMapper.INSTANCE.toDTO(doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found")));
    }

    @Override
    public DoctorDTO save(DoctorDTO doctor) {
        return DoctorMapper.INSTANCE.toDTO(doctorRepository.save(DoctorMapper.INSTANCE.toEntity(doctor)));
    }

    @Override
    public DoctorDTO update(DoctorDTO doctor, Long id) {
        DoctorDTO updatedDoctor = findDoctorById(id);
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
