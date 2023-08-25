package org.example.client;

import org.example.model.dto.CurrentRequestDTO;
import org.example.model.dto.WeatherClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient")
public interface WeatherClient {
    @GetMapping("/forecast.json")
    WeatherClientDTO getWeatherForecast(@RequestParam String key,
                                        @RequestParam("q") String cityName,
                                        @RequestParam int days,
                                        @RequestParam String aqi,
                                        @RequestParam String alerts);

    @GetMapping("/current.json")
    CurrentRequestDTO getCurrentWeather(@RequestParam String key,
                                        @RequestParam("q") String cityName,
                                        @RequestParam String aqi);
}
