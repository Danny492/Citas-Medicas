package com.citasmedicas_backend.services.impls;

import com.citasmedicas_backend.entities.CitaEntity;
import com.citasmedicas_backend.repositories.CitaRepository;
import com.citasmedicas_backend.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<CitaEntity> citas() {
        return citaRepository.findAll();
    }

    @Override
    public CitaEntity findById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public CitaEntity update(CitaEntity cita, Long id) {
        CitaEntity citaUpdated = findById(id);
        citaUpdated.setId(id);
        citaUpdated.setDescripcion(cita.getDescripcion());
        citaUpdated.setFechaHora(cita.getFechaHora());
        citaUpdated.setEstado(cita.getEstado());
        citaUpdated.setPaciente(cita.getPaciente());
        citaUpdated.setDoctor(cita.getDoctor());

        return save(citaUpdated);
    }

    @Override
    public CitaEntity save(CitaEntity cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void delete(Long id) {
        citaRepository.deleteById(id);
    }
}
