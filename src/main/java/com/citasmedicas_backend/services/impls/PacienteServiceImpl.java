package com.citasmedicas_backend.services.impls;

import com.citasmedicas_backend.entities.PacienteEntity;
import com.citasmedicas_backend.repositories.PacienteRepository;
import com.citasmedicas_backend.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<PacienteEntity> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public PacienteEntity findById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public PacienteEntity save(PacienteEntity paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public PacienteEntity update(PacienteEntity paciente, Long id) {
        PacienteEntity pacienteUpdated = findById(id);
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
