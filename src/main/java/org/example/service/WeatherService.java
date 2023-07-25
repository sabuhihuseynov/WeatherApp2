package org.example.service;

import org.example.model.dto.WeatherRequestDTO;
import org.example.model.dto.WeatherResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface WeatherService {
    void add(WeatherRequestDTO weatherRequestDto);

    Map<String, Map<LocalDate, List<WeatherResponseDTO>>> getAllByLocalDate(LocalDate localDate);

    Map<String, Map<LocalDate, List<WeatherResponseDTO>>> getByCityId(Long cityId);

    void update(Long id, WeatherRequestDTO weatherRequestDto);

    void delete(Long id);

}
