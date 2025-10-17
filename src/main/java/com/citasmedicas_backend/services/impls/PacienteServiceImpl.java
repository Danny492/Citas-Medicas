package com.citasmedicas_backend.services.impls;

import com.citasmedicas_backend.controllers.PacienteController;
import com.citasmedicas_backend.dtos.PacienteDTO;
import com.citasmedicas_backend.entities.PacienteEntity;
import com.citasmedicas_backend.mapper.PacienteMapper;
import com.citasmedicas_backend.repositories.PacienteRepository;
import com.citasmedicas_backend.services.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @Override
    public List<PacienteDTO> findAll() {
        return PacienteMapper.INSTANCE.toDto(pacienteRepository.findAll());
    }

    @Override
    public PacienteDTO findById(Long id) {
        return PacienteMapper.INSTANCE.toDto(pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente not found")));
    }

    @Override
    public PacienteDTO save(PacienteDTO paciente) {
        PacienteEntity pacienteEntity = PacienteMapper.INSTANCE.toEntity(paciente);
        pacienteEntity = pacienteRepository.save(pacienteEntity);

        return PacienteMapper.INSTANCE.toDto(pacienteEntity);
    }

    @Override
    public PacienteDTO update(PacienteDTO paciente, Long id) {
        PacienteDTO pacienteUpdated = findById(id);
        pacienteUpdated.setId(id);
        pacienteUpdated.setNombre(paciente.getNombre());
        pacienteUpdated.setCedula(paciente.getCedula());
        pacienteUpdated.setCorreo(paciente.getCorreo());
        pacienteUpdated.setTelefono(paciente.getTelefono());

        return save(pacienteUpdated);
    }

    @Override
    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }
}
