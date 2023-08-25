package org.example.model.dto;

import java.util.List;

public record ForecastRequestDTO(List<ForecastDayRequestDTO> forecastday) {
}
