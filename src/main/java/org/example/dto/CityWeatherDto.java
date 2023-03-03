package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityWeatherDto {
    private Integer weatherId;
    private LocalDate date;
    private double temperature;
    private LocalTime time;
    private String type;
    private double windSpeed;
    private Integer cityId;
    private String cityName;

}
