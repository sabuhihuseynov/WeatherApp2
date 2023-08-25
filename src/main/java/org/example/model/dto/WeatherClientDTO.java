package org.example.model.dto;

public record WeatherClientDTO(LocationRequestDTO location,
                               CurrentWeatherRequestDTO current,
                               ForecastRequestDTO forecast) {
}
