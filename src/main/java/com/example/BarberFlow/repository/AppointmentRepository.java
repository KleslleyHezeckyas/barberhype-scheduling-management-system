package com.example.BarberFlow.repository;

import com.example.BarberFlow.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDateTime(LocalDateTime dateTime);

    @Query("SELECT SUM(a.service.price) FROM Appointment a")
    Double getTotalRevenue();
}
