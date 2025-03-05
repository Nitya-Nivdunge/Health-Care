package com.example.controller;



import com.example.entity.Prescription;
import com.example.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Create Prescription
    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // Get All Prescriptions
    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get Prescription by ID
    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    // Update Prescription
    @PutMapping("/{id}")
    public Prescription updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails) {
        Prescription prescription = prescriptionRepository.findById(id).orElse(null);
        if (prescription != null) {
            prescription.setPatientName(prescriptionDetails.getPatientName());
            prescription.setMedication(prescriptionDetails.getMedication());
            prescription.setDosage(prescriptionDetails.getDosage());
            return prescriptionRepository.save(prescription);
        }
        return null;
    }

    // Delete Prescription
    @DeleteMapping("/{id}")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionRepository.deleteById(id);
        return "Prescription deleted successfully!";
    }
}
