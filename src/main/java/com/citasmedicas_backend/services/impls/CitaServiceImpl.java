package com.citasmedicas_backend.services.impls;

import com.citasmedicas_backend.dtos.CitaDTO;
import com.citasmedicas_backend.entities.CitaEntity;
import com.citasmedicas_backend.entities.DoctorEntity;
import com.citasmedicas_backend.entities.PacienteEntity;
import com.citasmedicas_backend.mappers.CitaMapper;
import com.citasmedicas_backend.repositories.CitaRepository;
import com.citasmedicas_backend.repositories.DoctorRepository;
import com.citasmedicas_backend.repositories.PacienteRepository;
import com.citasmedicas_backend.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<CitaDTO> citas() {
        return CitaMapper.INSTANCE.toDTO(citaRepository.findAll());
    }

    @Override
    public CitaDTO findById(Long id) {
        return CitaMapper.INSTANCE.toDTO(citaRepository.findById(id).orElse(null));
    }

    @Override
    public CitaDTO update(CitaDTO cita, Long id) {
        CitaDTO citaUpdated = findById(id);

        citaUpdated.setId(id);
        citaUpdated.setDescripcion(cita.getDescripcion());
        citaUpdated.setFechaHora(cita.getFechaHora());
        citaUpdated.setEstado(cita.getEstado());
        citaUpdated.setPacienteId(cita.getPacienteId());
        citaUpdated.setDoctorId(cita.getDoctorId());

        return save(citaUpdated);
    }

    @Override
    public CitaDTO save(CitaDTO cita) {
        DoctorEntity doctor = doctorRepository.findById(cita.getDoctorId()).orElse(null);
        PacienteEntity paciente = pacienteRepository.findById(cita.getPacienteId()).orElse(null);
        CitaEntity citaEntity = CitaMapper.INSTANCE.toEntity(cita);
        citaEntity.setDoctor(doctor);
        citaEntity.setPaciente(paciente);
        return CitaMapper.INSTANCE.toDTO(citaRepository.save(citaEntity));
    }

    @Override
    public void delete(Long id) {
        citaRepository.deleteById(id);
    }
}
