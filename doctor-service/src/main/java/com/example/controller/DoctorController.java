package com.example.controller;

import com.example.model.Doctor;
import com.example.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor_service/doctors") // Updated Base Path
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // Test API for checking service availability
    @GetMapping("/test")
    public String testService() {
        return "Doctor Service is working!";
    }

    // Create a new doctor
    @PostMapping("/create")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    // Get all doctors
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get a doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id)
                .map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a doctor
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(doctorDetails.getName());
                    doctor.setSpecialization(doctorDetails.getSpecialization());
                    doctor.setExperience(doctorDetails.getExperience());
                    Doctor updatedDoctor = doctorRepository.save(doctor);
                    return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a doctor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
