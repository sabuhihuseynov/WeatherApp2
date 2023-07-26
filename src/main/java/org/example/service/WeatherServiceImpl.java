package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.City;
import org.example.dao.entity.Weather;
import org.example.dao.repository.WeatherRepository;
import org.example.error.exceptions.NotFoundException;
import org.example.model.consts.Messages;
import org.example.mapper.WeatherMapper;
import org.example.model.dto.WeatherRequestDTO;
import org.example.model.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;
    private final WeatherMapper mapper;

    @Override
    public Map<String, Map<LocalDate, List<WeatherResponseDTO>>> getAllByLocalDate(LocalDate localDate) {
        log.info("Action.getAllByLocalDate.start");
        Map<String, Map<LocalDate, List<WeatherResponseDTO>>> weatherMap = new HashMap<>();
        List<Weather> weatherList = repository.findAllByDate(localDate);

        for (Weather weather : weatherList) {
            String cityName = weather.getCity().getName();
            weatherMap.putIfAbsent(cityName, new HashMap<>());
            weatherMap.get(cityName).putIfAbsent(localDate, new ArrayList<>());
            weatherMap.get(cityName).get(localDate).add(mapper.toDTO(weather));
        }
        return weatherMap;
    }

    @Override
    public Map<String, Map<LocalDate, List<WeatherResponseDTO>>> getByCityId(Long cityId) {
        log.info("Action.getByCityId.start");
        Map<String, Map<LocalDate, List<WeatherResponseDTO>>> weatherMap = new HashMap<>();
        List<Weather> weatherList = repository.findWeatherByCityId(cityId);
        String cityName = weatherList.get(0).getCity().getName();
        weatherMap.put(cityName, getWeatherDTOMap(weatherList));
        return weatherMap;
    }

    private Map<LocalDate, List<WeatherResponseDTO>> getWeatherDTOMap(List<Weather> weatherList) {
        return weatherList.stream()
                .collect(Collectors.groupingBy(Weather::getDate,
                        Collectors.mapping(mapper::toDTO, Collectors.toList())));
    }

    @Override
    public void add(WeatherRequestDTO weatherRequestDto) {
        log.info("Action.add.start");
        City city = new City();
        city.setId(weatherRequestDto.cityId());
        Weather weather = mapper.toEntity(weatherRequestDto, city);
        repository.save(weather);
        log.info("Action.add.end");
    }

    @Override
    public void update(Long id, WeatherRequestDTO weatherRequestDto) {
        log.info("Action.update.start");
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Messages.WEATHER_NOT_FOUND, Messages.WEATHER_NOT_FOUND_MSG));
        City city = new City();
        city.setId(weatherRequestDto.cityId());
        Weather weather = mapper.toEntity(weatherRequestDto, city);
        weather.setId(id);
        repository.save(weather);
        log.info("Action.update.end");
    }

    @Override
    public void delete(Long id) {
        log.info("Action.delete.start");
        repository.deleteById(id);
        log.info("Action.delete.start");
    }

}
