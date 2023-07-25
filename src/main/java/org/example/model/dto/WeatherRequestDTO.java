package org.example.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record WeatherRequestDTO(String type,
                                double temperature,
                                double windSpeed,
                                LocalDate date,
                                LocalTime time,
                                Long cityId) {
}
