package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.WeatherRequestDTO;
import org.example.model.dto.WeatherResponseDTO;
import org.example.service.WeatherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Map<String, Map<LocalDate, List<WeatherResponseDTO>>> getAll(@RequestParam LocalDate localDate) {
        return weatherService.getAllByLocalDate(localDate);
    }

    @GetMapping("/{cityId}")
    public Map<String, Map<LocalDate, List<WeatherResponseDTO>>> getByCityId(@PathVariable Long cityId) {
        return weatherService.getByCityId(cityId);
    }

    @PostMapping
    public void create(@RequestBody WeatherRequestDTO weatherRequestDto) {
        weatherService.add(weatherRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody WeatherRequestDTO weatherRequestDto) {
        weatherService.update(id, weatherRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        weatherService.delete(id);
    }
}
