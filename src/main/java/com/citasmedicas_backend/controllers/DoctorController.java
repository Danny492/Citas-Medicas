package com.citasmedicas_backend.controllers;

import com.citasmedicas_backend.dtos.DoctorDTO;
import com.citasmedicas_backend.services.impls.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctores")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
        return new ResponseEntity<>(doctorService.doctors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable Long id) {
        DoctorDTO doctor = doctorService.findDoctorById(id);
        if (doctor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@Valid @RequestBody DoctorDTO doctor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(doctorService.save(doctor), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDoctor(@Valid @PathVariable Long id, @RequestBody DoctorDTO doctor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(doctorService.update(doctor,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.ok("Doctor deleted");
    }
}
