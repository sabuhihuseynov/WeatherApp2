package org.example.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CityRequestDTO(@NotBlank(message = "The city name is required.") String name,
                             Long countryId) {

}
