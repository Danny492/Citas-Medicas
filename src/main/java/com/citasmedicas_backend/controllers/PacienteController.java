package com.citasmedicas_backend.controllers;

import com.citasmedicas_backend.entities.PacienteEntity;
import com.citasmedicas_backend.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteEntity>> findAll() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteEntity> save(@RequestBody PacienteEntity paciente) {
        return ResponseEntity.ok(pacienteService.save(paciente));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PacienteEntity> update(@RequestBody PacienteEntity paciente, @PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.update(paciente, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pacienteService.delete(id);
        return ResponseEntity.ok("Patient deleted");
    }
}
