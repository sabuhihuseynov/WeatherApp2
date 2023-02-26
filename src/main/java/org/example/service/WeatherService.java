package org.example.service;

import org.example.dto.WeatherRequestDto;
import org.example.dto.WeatherResponseDto;
import org.example.entity.Weather;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface WeatherService {
    void create(WeatherRequestDto weatherRequestDto);

    Map<String, Map<LocalDate, List<WeatherResponseDto>>> getAll();

    Map<String, Map<LocalDate, List<WeatherResponseDto>>> getByCityId(Integer cityId);

    List<WeatherResponseDto> getWeather(LocalDate localDate, List<Weather> weatherList, String cityName);

    void update(Integer id, WeatherRequestDto weatherRequestDto);

    void delete(Integer id);

}
