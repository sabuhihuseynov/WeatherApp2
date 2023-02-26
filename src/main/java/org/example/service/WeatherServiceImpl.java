package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.CityWeatherDto;
import org.example.dto.WeatherRequestDto;
import org.example.dto.WeatherResponseDto;
import org.example.entity.City;
import org.example.entity.Weather;
import org.example.error.EntityNotFoundException;
import org.example.mapper.CityMapper;
import org.example.mapper.WeatherMapper;
import org.example.repository.CityRepository;
import org.example.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;
    private final WeatherMapper weatherMapper;
    private final CityMapper cityMapper;

    public void create(WeatherRequestDto weatherRequestDto) {
        City city = cityRepository.findById(weatherRequestDto.getCityId()).
                orElseThrow(() -> new EntityNotFoundException("City.error-message"));
        Weather weather = Weather.builder()
                .type(weatherRequestDto.getType())
                .city(city)
                .date(weatherRequestDto.getDate())
                .time(weatherRequestDto.getTime())
                .temperature(weatherRequestDto.getTemperature())
                .windSpeed(weatherRequestDto.getWindSpeed())
                .build();
        weatherRepository.save(weather);
    }

    public Map<String, Map<LocalDate, List<WeatherResponseDto>>> getAll() {
        Map<String, Map<LocalDate, List<WeatherResponseDto>>> weatherMap = new HashMap<>();
        List<CityWeatherDto> cityWeatherDtoList = weatherRepository.getAllWithCities();
        List<City> cities = cityMapper.covertCityWeatherDTOtoCityList(cityWeatherDtoList);
        List<Weather> weatherList = weatherMapper.convertCityWeatherDTOtoWeatherList(cityWeatherDtoList);
        for (City city : cities) {
            Map<LocalDate, List<WeatherResponseDto>> weatherListForCustomCity = new HashMap<>();
            String cityName = city.getName();
            for (Weather weather : weatherList) {
                if (cityName.equals(weather.getCity().getName())) {
                    LocalDate localDate = weather.getDate();
                    if (weatherListForCustomCity.containsKey(localDate)) {
                        continue;
                    }
                    List<WeatherResponseDto> weatherResponseDtoList = getWeather(localDate, weatherList, cityName);
                    weatherListForCustomCity.put(localDate, weatherResponseDtoList);
                }
            }
            weatherMap.put(cityName, weatherListForCustomCity);
        }
        return weatherMap;
    }

    public Map<String, Map<LocalDate, List<WeatherResponseDto>>> getByCityId(Integer cityId) {
        Map<String, Map<LocalDate, List<WeatherResponseDto>>> weatherMap = new HashMap<>();
        HashMap<LocalDate, List<WeatherResponseDto>> weatherListForCustomCity = new HashMap<>();
        List<CityWeatherDto> cityWeatherDtoList = weatherRepository.getWeatherAndCityByCityId(cityId);
        if (cityWeatherDtoList.isEmpty()) {
            throw new EntityNotFoundException("Weather");
        }
        List<Weather> weatherList = weatherMapper.convertCityWeatherDTOtoWeatherList(cityWeatherDtoList);
        String cityName = weatherList.get(0).getCity().getName();
        for (Weather weather : weatherList) {
            LocalDate localDate = weather.getDate();
            if (weatherListForCustomCity.containsKey(localDate)) {
                continue;
            }
            List<WeatherResponseDto> weatherResponseDtoList = getWeather(localDate, weatherList, cityName);
            weatherListForCustomCity.put(localDate, weatherResponseDtoList);
        }
        weatherMap.put(cityName, weatherListForCustomCity);
        return weatherMap;
    }

    public List<WeatherResponseDto> getWeather(LocalDate localDate, List<Weather> weatherList, String cityName) {
        List<WeatherResponseDto> weatherForLocalDate = new ArrayList<>();
        for (Weather weather : weatherList) {
            if (cityName.equals(weather.getCity().getName()) && localDate.equals(weather.getDate())) {
                weatherForLocalDate.add(weatherMapper.toWeatherResponseDto(weather));
            }
        }
        return weatherForLocalDate;
    }
    

    public void update(Integer id, WeatherRequestDto weatherRequestDto) {
        Weather weather = weatherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Weather"));
        weather.setType(weatherRequestDto.getType());
        weather.setTime(weatherRequestDto.getTime());
        weather.setTemperature(weatherRequestDto.getTemperature());
        weather.setDate(weatherRequestDto.getDate());
        weather.setWindSpeed(weatherRequestDto.getWindSpeed());
        weather.setCity(cityRepository.findById(weatherRequestDto.getCityId()).orElseThrow());
        weatherRepository.save(weather);
    }

    public void delete(Integer id) {
        weatherRepository.deleteById(id);
    }

}
