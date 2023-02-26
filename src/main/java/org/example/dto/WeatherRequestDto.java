package org.example.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class WeatherRequestDto {

    private String type;
    private double temperature;
    private double windSpeed;
    private LocalDate date;
    private LocalTime time;
    private Integer cityId;

}
