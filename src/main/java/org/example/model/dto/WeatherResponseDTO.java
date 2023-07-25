package org.example.model.dto;

import java.time.LocalTime;

public record WeatherResponseDTO(String type,
                                 double temperature,
                                 double windSpeed,
                                 LocalTime time) {
}
