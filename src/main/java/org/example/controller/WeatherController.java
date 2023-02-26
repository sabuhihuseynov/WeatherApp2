package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.WeatherRequestDto;
import org.example.dto.WeatherResponseDto;
import org.example.service.WeatherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/weathers")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public Map<String, Map<LocalDate, List<WeatherResponseDto>>> getAll() {
        return weatherService.getAll();
    }

    @GetMapping("/{cityId}")
    public Map<String, Map<LocalDate, List<WeatherResponseDto>>> getByCityId(@PathVariable Integer cityId) {
        return weatherService.getByCityId(cityId);
    }

    @PostMapping
    public void create(@RequestBody WeatherRequestDto weatherRequestDto) {
        weatherService.create(weatherRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody WeatherRequestDto weatherRequestDto) {
        weatherService.update(id, weatherRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        weatherService.delete(id);
    }
}
