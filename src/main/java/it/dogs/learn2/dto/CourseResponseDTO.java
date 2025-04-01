package it.dogs.learn2.dto;

import it.dogs.learn2.model.DeliveryMode;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record CourseResponseDTO(
        Long id,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        DeliveryMode deliveryMode
){}
