package org.example.service;

import org.example.model.dto.CurrentResponseDTO;
import org.example.model.dto.ForecastResponseDTO;

public interface WeatherService {

    ForecastResponseDTO getForecastByCity(Long cityId);

    CurrentResponseDTO getCurrentWeather(Long cityId);

    void saveWeatherForecast(int days);
}
