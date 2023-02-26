package org.example.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class WeatherResponseDto {

    public String type;
    public double temperature;
    public double windSpeed;
    LocalTime time;

}
