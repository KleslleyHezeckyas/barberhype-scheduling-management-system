package com.example.BarberFlow.controller;

import com.example.BarberFlow.domain.ServiceEntity;
import com.example.BarberFlow.repository.ServiceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return repository.findAll();
    }
}
