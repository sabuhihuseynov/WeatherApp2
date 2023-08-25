package org.example.model.dto;

import java.time.LocalDate;
import java.util.List;

public record ForecastDayResponseDTO(LocalDate date,
                                     DayResponseDTO day,
                                     AstroDTO astro,
                                     List<HourlyWeatherResponseDTO> hour) {
}
