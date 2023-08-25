package org.example.model.dto;

public record DayRequestDTO(
        double maxtemp_c,
        double maxtemp_f,
        double mintemp_c,
        double mintemp_f,
        double avgtemp_c,
        double avgtemp_f,
        double maxwind_kph,
        double totalsnow_cm,
        WeatherConditionDTO condition
) {
}
