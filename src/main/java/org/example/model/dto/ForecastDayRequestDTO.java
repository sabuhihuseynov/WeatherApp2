package org.example.model.dto;

import java.time.LocalDate;
import java.util.List;

public record ForecastDayRequestDTO(LocalDate date,
                                    DayRequestDTO day,
                                    AstroDTO astro,
                                    List<HourlyWeatherRequestDTO> hour) {
}
