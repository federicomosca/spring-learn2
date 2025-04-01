package it.dogs.learn2.dto;

import it.dogs.learn2.model.DeliveryMode;

import java.time.LocalDate;

public record CourseRequestDTO(
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        DeliveryMode deliveryMode
){}
