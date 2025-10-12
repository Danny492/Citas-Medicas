package com.citasmedicas_backend.controllers;

import com.citasmedicas_backend.entities.DoctorEntity;
import com.citasmedicas_backend.services.impls.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctores")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorEntity>> getDoctors() {
        return ResponseEntity.ok(doctorService.doctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorEntity> getDoctor(@PathVariable Long id) {
        return ResponseEntity.ok().body(doctorService.findDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorEntity> addDoctor(@RequestBody DoctorEntity doctor) {
        return ResponseEntity.ok().body(doctorService.save(doctor));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorEntity> updateDoctor(@PathVariable Long id, @RequestBody DoctorEntity doctor) {
        return ResponseEntity.ok().body(doctorService.update(doctor,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.ok("Doctor deleted");
    }
}
