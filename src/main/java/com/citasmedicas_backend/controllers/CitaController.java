package com.citasmedicas_backend.controllers;

import com.citasmedicas_backend.entities.CitaEntity;
import com.citasmedicas_backend.services.impls.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/citas")
public class CitaController {

    @Autowired
    private CitaServiceImpl citaService;

    @GetMapping
    public ResponseEntity<List<CitaEntity>> getCitas(){
        return ResponseEntity.ok(citaService.citas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaEntity> getCitaById(@PathVariable Long id){
        return ResponseEntity.ok(citaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CitaEntity> createCita(@RequestBody CitaEntity cita){
        return ResponseEntity.ok(citaService.save(cita));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CitaEntity> updateCita(@PathVariable Long id, @RequestBody CitaEntity cita){
        return ResponseEntity.ok(citaService.update(cita,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCita(@PathVariable Long id){
        citaService.delete(id);
        return ResponseEntity.ok("Cita deleted Successfully");
    }
}
