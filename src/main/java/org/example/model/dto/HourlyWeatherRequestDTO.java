package org.example.model.dto;

public record HourlyWeatherRequestDTO(String time,
                                      double temp_c,
                                      double temp_f,
                                      WeatherConditionDTO condition,
                                      double wind_kph) {
}
