package com.example.BarberFlow.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRequest {
    private String clientName;
    private LocalDateTime dateTime;
    private Long serviceId;
}
