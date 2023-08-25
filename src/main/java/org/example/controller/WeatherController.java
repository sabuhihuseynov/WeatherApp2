package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.CurrentResponseDTO;
import org.example.model.dto.ForecastResponseDTO;
import org.example.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weathers")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{cityId}/forecast")
    public ForecastResponseDTO getForecast(@PathVariable Long cityId) {
        return weatherService.getForecastByCity(cityId);
    }

    @GetMapping("/{cityId}/current")
    public CurrentResponseDTO getCurrentWeather(@PathVariable Long cityId) {
        return weatherService.getCurrentWeather(cityId);
    }

}
