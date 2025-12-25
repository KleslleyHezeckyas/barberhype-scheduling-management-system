package com.example.BarberFlow.controller;

import com.example.BarberFlow.domain.Appointment;
import com.example.BarberFlow.dto.AppointmentRequest;
import com.example.BarberFlow.service.AppointmentService;
import com.example.BarberFlow.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @Autowired
    private AppointmentRepository repository;

    @PostMapping
    public Appointment create(@RequestBody AppointmentRequest request) {
        return service.createAppointment(request);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/revenue")
    public Double getRevenue() {
        Double total = repository.getTotalRevenue();
        return total != null ? total : 0.0;
    }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable Long id, @RequestBody AppointmentRequest request ) {
        return service.updateAppointment(id, request);
    }

    @PatchMapping("/{id}/complete")
    public Appointment complete(@PathVariable Long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setCompleted(true);
        return repository.save(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
