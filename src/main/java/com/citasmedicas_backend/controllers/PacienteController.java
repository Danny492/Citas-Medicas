package com.citasmedicas_backend.controllers;

import com.citasmedicas_backend.dtos.PacienteDTO;
import com.citasmedicas_backend.entities.PacienteEntity;
import com.citasmedicas_backend.services.PacienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() {
        return new ResponseEntity<>(pacienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.findById(id);
        if(paciente == null) {
            return new ResponseEntity<>(paciente,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PacienteDTO paciente, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pacienteService.save(paciente), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PacienteDTO paciente, @PathVariable Long id, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pacienteService.update(paciente, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pacienteService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
