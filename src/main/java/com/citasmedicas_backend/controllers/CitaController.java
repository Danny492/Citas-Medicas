package com.citasmedicas_backend.controllers;

import com.citasmedicas_backend.dtos.CitaDTO;
import com.citasmedicas_backend.services.impls.CitaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/citas")
public class CitaController {

    @Autowired
    private CitaServiceImpl citaService;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> getCitas(){
        if (citaService.citas().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(citaService.citas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> getCitaById(@PathVariable Long id){
        return ResponseEntity.ok(citaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCita(@Valid @RequestBody CitaDTO cita, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(citaService.save(cita), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCita(@Valid@RequestBody CitaDTO cita, BindingResult bindingResult, @PathVariable Long id){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(citaService.update(cita, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCita(@PathVariable Long id){
        citaService.delete(id);
        return new ResponseEntity<>("Cita deleted Successfully", HttpStatus.OK);
    }
}