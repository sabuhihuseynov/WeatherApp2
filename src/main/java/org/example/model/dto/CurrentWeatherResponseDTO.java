package org.example.model.dto;

public record CurrentWeatherResponseDTO(double temp_c,
                                        double temp_f,
                                        WeatherConditionDTO condition,
                                        double windSpeed,
                                        int humidity,
                                        int cloud
) {
}

