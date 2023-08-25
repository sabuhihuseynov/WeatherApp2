package org.example.mapper;

import org.example.dao.entity.Astro;
import org.example.dao.entity.Day;
import org.example.dao.entity.ForecastDay;
import org.example.dao.entity.HourlyWeather;
import org.example.dao.entity.Location;
import org.example.dao.entity.WeatherCondition;
import org.example.model.dto.AstroDTO;
import org.example.model.dto.HourlyWeatherRequestDTO;
import org.example.model.dto.HourlyWeatherResponseDTO;
import org.example.model.dto.WeatherConditionDTO;
import org.example.model.dto.CurrentRequestDTO;
import org.example.model.dto.CurrentResponseDTO;
import org.example.model.dto.CurrentWeatherRequestDTO;
import org.example.model.dto.CurrentWeatherResponseDTO;
import org.example.model.dto.DayRequestDTO;
import org.example.model.dto.DayResponseDTO;
import org.example.model.dto.ForecastDayRequestDTO;
import org.example.model.dto.ForecastDayResponseDTO;
import org.example.model.dto.LocationRequestDTO;
import org.example.model.dto.LocationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface WeatherMapper {

    LocationResponseDTO toLocationResponseDTO(Location location);

    @Mapping(target = "windSpeed", source = "wind_kph")
    CurrentWeatherResponseDTO toCurrentWeatherResponseDTO(CurrentWeatherRequestDTO currentWeatherRequestDTO);

    CurrentResponseDTO toCurrentResponseDTO(CurrentRequestDTO currentRequestDTO);

    @Mapping(target = "condition", source = "weatherCondition")
    DayResponseDTO toDayResponseDTO(Day day);

    @Mapping(target = "condition", source = "weatherCondition")
    HourlyWeatherResponseDTO toHourlyWeatherResponseDTO(HourlyWeather hourlyWeather);

    @Mapping(target = "hour", source = "hourlyWeatherList")
    ForecastDayResponseDTO toForecastDayResponseDTO(ForecastDay forecastDay);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "hourlyWeatherList", ignore = true)
    ForecastDay toForecastDayEntity(ForecastDayRequestDTO forecastDayRequestDTO
            , Location location);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Astro toAstroEntity(AstroDTO astroDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "maxWind", source = "dayRequestDTO.maxwind_kph")
    Day toDayEntity(DayRequestDTO dayRequestDTO, WeatherCondition weatherCondition);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "windSpeed", source = "hourlyWeatherRequestDTO.wind_kph")
    HourlyWeather toHourlyWeatherEntity(
            HourlyWeatherRequestDTO hourlyWeatherRequestDTO,
            WeatherCondition weatherCondition,
            ForecastDay forecastDay);

    @Mapping(target = "cityName", source = "name")
    @Mapping(target = "countryName", source = "country")
    @Mapping(target = "latitude", source = "lat")
    @Mapping(target = "longitude", source = "lon")
    Location toLocationEntity(LocationRequestDTO locationRequestDTO);

    WeatherCondition toWeatherConditionEntity(WeatherConditionDTO weatherConditionDTO);

}
