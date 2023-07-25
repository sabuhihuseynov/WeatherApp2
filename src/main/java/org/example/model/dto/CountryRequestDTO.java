package org.example.model.dto;

import jakarta.validation.constraints.NotBlank;
public record CountryRequestDTO(@NotBlank(message = "The country name is required.") String name) {
}
