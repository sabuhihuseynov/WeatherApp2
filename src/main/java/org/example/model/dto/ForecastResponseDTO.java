package org.example.model.dto;

import java.util.List;

public record ForecastResponseDTO(LocationResponseDTO location,
                                  List<ForecastDayResponseDTO> forecast) {
}
