package org.example.mapper;

import org.example.dto.CityWeatherDto;
import org.example.dto.WeatherResponseDto;
import org.example.entity.City;
import org.example.entity.Weather;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherMapper {

    public WeatherResponseDto toWeatherResponseDto(Weather weather) {
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
        weatherResponseDto.setType(weather.getType());
        weatherResponseDto.setTemperature(weather.getTemperature());
        weatherResponseDto.setWindSpeed(weather.getWindSpeed());
        weatherResponseDto.setTime(weather.getTime());
        return weatherResponseDto;
    }

    public List<Weather> convertCityWeatherDTOtoWeatherList(List<CityWeatherDto> cityWeatherDtoList) {
        List<Weather> weatherList = new ArrayList<>();
        for (CityWeatherDto cityWeatherDto : cityWeatherDtoList) {
            Weather weather = new Weather();
            City city = new City();
            city.setId(cityWeatherDto.getCityId());
            city.setName(cityWeatherDto.getCityName());
            weather.setId(cityWeatherDto.getWeatherId());
            weather.setType(cityWeatherDto.getType());
            weather.setTime(cityWeatherDto.getTime());
            weather.setTemperature(cityWeatherDto.getTemperature());
            weather.setDate(cityWeatherDto.getDate());
            weather.setWindSpeed(cityWeatherDto.getWindSpeed());
            weather.setCity(city);
            weatherList.add(weather);
        }
        return weatherList;
    }

}
