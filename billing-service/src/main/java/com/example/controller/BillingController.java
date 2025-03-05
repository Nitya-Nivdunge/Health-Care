package com.example.controller;

import com.example.model.Billing;
import com.example.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billings")
public class BillingController {

    @Autowired
    private BillingRepository billingRepository;

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }

    @GetMapping
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Billing> getBillingById(@PathVariable Long id) {
        return billingRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Billing updateBilling(@PathVariable Long id, @RequestBody Billing billingDetails) {
        Billing billing = billingRepository.findById(id).orElseThrow();
        billing.setPatientId(billingDetails.getPatientId());
        billing.setAppointmentId(billingDetails.getAppointmentId());
        billing.setAmount(billingDetails.getAmount());
        billing.setStatus(billingDetails.getStatus());
        billing.setDate(billingDetails.getDate());
        return billingRepository.save(billing);
    }

    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable Long id) {
        billingRepository.deleteById(id);
    }
}
