package org.example.model.dto;

public record HourlyWeatherResponseDTO(String time,
                                       double temp_c,
                                       double temp_f,
                                       WeatherConditionDTO condition,
                                       double windSpeed) {
}
