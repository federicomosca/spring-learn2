package it.dogs.learn2.dto;

import java.time.LocalDate;

public record UserRequestDTO(
        String firstName,
        String lastName,
        String email,
        LocalDate birthDate,
        String fiscalCode
) {}
