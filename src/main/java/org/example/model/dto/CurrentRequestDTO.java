package org.example.model.dto;

public record CurrentRequestDTO(LocationRequestDTO location,
                                CurrentWeatherRequestDTO current) {
}
