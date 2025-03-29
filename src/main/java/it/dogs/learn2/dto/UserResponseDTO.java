package it.dogs.learn2.dto;

import java.time.LocalDate;

public record UserResponseDTO (Long id,
                               String firstName,
                               String lastName,
                               String email,
                               LocalDate birthDate,
                               String fiscalCode) {}
