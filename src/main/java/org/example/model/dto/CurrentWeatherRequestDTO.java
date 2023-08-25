package org.example.model.dto;

public record CurrentWeatherRequestDTO(
        double temp_c,
        double temp_f,
        WeatherConditionDTO condition,
        double wind_kph,
        int humidity,
        int cloud,
        double uv
) {
}
