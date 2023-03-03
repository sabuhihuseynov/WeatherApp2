package org.example.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class WeatherResponseDto {

    private String type;
    private double temperature;
    private double windSpeed;
    private LocalTime time;

}
