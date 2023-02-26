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
    Integer weatherId;
    LocalDate date;
    double temperature;
    LocalTime time;
    String type;
    double windSpeed;
    Integer cityId;
    String cityName;

}
