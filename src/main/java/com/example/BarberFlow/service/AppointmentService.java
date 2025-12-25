package com.example.BarberFlow.service;

import com.example.BarberFlow.domain.Appointment;
import com.example.BarberFlow.domain.ServiceEntity;
import com.example.BarberFlow.dto.AppointmentRequest;
import com.example.BarberFlow.repository.AppointmentRepository;
import com.example.BarberFlow.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ServiceRepository serviceRepository;
    public Appointment createAppointment(AppointmentRequest request) {
        if (request.getDateTime().isBefore(LocalDateTime.now().minusMinutes(5))) {
            throw new RuntimeException("You cannot book a time in the past!");
        }

        if (appointmentRepository.findByDateTime(request.getDateTime()).isPresent()) {
            throw new RuntimeException("This time slot is already booked!");
        }

        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        Appointment appointment = new Appointment();
        appointment.setClientName(request.getClientName());
        appointment.setDateTime(request.getDateTime());
        appointment.setService(service);

        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, AppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        appointment.setClientName(request.getClientName());
        appointment.setDateTime(request.getDateTime());
        appointment.setService(service);

        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        appointmentRepository.deleteById(id);
    }

}