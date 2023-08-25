package org.example.model.dto;

public record CurrentResponseDTO(LocationResponseDTO location,
                                 CurrentWeatherResponseDTO current) {
}
