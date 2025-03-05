package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate appointmentDate;
    private LocalTime time;
    private String doctorName;
    private String patientName;
    private String status;

    public void setId(Long id) {
    }

    // Getters and Setters
}
