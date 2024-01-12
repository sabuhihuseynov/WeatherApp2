package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.client.WeatherClient;
import org.example.dao.entity.Astro;
import org.example.dao.entity.City;
import org.example.dao.entity.Day;
import org.example.dao.entity.ForecastDay;
import org.example.dao.entity.HourlyWeather;
import org.example.dao.entity.Location;
import org.example.dao.entity.WeatherCondition;
import org.example.dao.repository.CityRepository;
import org.example.dao.repository.ForecastDayRepository;
import org.example.dao.repository.HourlyWeatherRepository;
import org.example.dao.repository.LocationRepository;
import org.example.dao.repository.WeatherConditionRepository;
import org.example.error.exceptions.NotFoundException;
import org.example.model.consts.Messages;
import org.example.mapper.WeatherMapper;
import org.example.model.dto.CurrentRequestDTO;
import org.example.model.dto.CurrentResponseDTO;
import org.example.model.dto.ForecastDayRequestDTO;
import org.example.model.dto.ForecastDayResponseDTO;
import org.example.model.dto.ForecastResponseDTO;
import org.example.model.dto.HourlyWeatherRequestDTO;
import org.example.model.dto.WeatherClientDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private static final String key = System.getenv("WEATHER_API_KEY");
    private final WeatherClient client;
    private final WeatherMapper mapper;
    private final CityRepository cityRepository;
    private final ForecastDayRepository repository;
    private final HourlyWeatherRepository hourlyWeatherRepository;
    private final LocationRepository locationRepository;
    private final WeatherConditionRepository weatherConditionRepository;

    @Override
    public ForecastResponseDTO getForecastByCity(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new NotFoundException(Messages.CITY_NOT_FOUND, Messages.CITY_NOT_FOUND_MSG));
        Location location = locationRepository.findByCityName(city.getName());
        List<ForecastDayResponseDTO> forecastDayResponseDTOS = repository
                .getForecastDayByLocation_IdAndDateGreaterThan(location.getId(), LocalDate.now()).stream()
                .map(mapper::toForecastDayResponseDTO)
                .toList();
        return new ForecastResponseDTO(mapper.toLocationResponseDTO(location), forecastDayResponseDTOS);
    }

    @Override
    public CurrentResponseDTO getCurrentWeather(Long cityId) {
        log.info("Action.getCurrentWeather.start");
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new NotFoundException(Messages.CITY_NOT_FOUND, Messages.CITY_NOT_FOUND_MSG));
        CurrentRequestDTO currentRequestDTO = client.getCurrentWeather(key, city.getName(), "no");
        return mapper.toCurrentResponseDTO(currentRequestDTO);
    }

    @Transactional
    public void saveWeatherForecast(int days) {
        log.info("Action.saveWeatherForecast.start");
        List<String> cities = cityRepository.findAll().stream()
                .map(City::getName)
                .toList();
        for (String cityName : cities) {
            WeatherClientDTO weatherClientDTO = client.getWeatherForecast(key, cityName, days, "no", "no");
            Location location = locationRepository.findByCityName(cityName);
            if (location == null) {
                location = mapper.toLocationEntity(weatherClientDTO.location());
            }
            locationRepository.save(location);
            for (ForecastDayRequestDTO forecastRequestDTO : weatherClientDTO.forecast().forecastday()) {

                ForecastDay forecastDay = mapper.toForecastDayEntity(forecastRequestDTO, location);

                Astro astro = mapper.toAstroEntity(forecastRequestDTO.astro());

                WeatherCondition weatherConditionForDay = mapper.
                        toWeatherConditionEntity(forecastRequestDTO.day().condition());
                weatherConditionRepository.save(weatherConditionForDay);
                Day day = mapper.toDayEntity(forecastRequestDTO.day(), weatherConditionForDay);

                forecastDay.setDay(day);
                forecastDay.setAstro(astro);
                repository.save(forecastDay);

                List<HourlyWeather> hourlyWeathers = new ArrayList<>();

                for (HourlyWeatherRequestDTO hourlyWeatherRequestDTO : forecastRequestDTO.hour()) {
                    WeatherCondition weatherCondition = mapper.toWeatherConditionEntity(hourlyWeatherRequestDTO.condition());
                    weatherConditionRepository.save(weatherCondition);
                    HourlyWeather hourlyWeather = mapper.toHourlyWeatherEntity(hourlyWeatherRequestDTO, weatherCondition
                            , forecastDay);
                    hourlyWeathers.add(hourlyWeather);
                }
                hourlyWeatherRepository.saveAll(hourlyWeathers);
            }
        }
    }


}
