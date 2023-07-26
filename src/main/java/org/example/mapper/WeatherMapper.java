package org.example.mapper;

import org.example.dao.entity.City;
import org.example.dao.entity.Weather;
import org.example.model.dto.WeatherRequestDTO;
import org.example.model.dto.WeatherResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface WeatherMapper {

    WeatherResponseDTO toDTO(Weather weather);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Weather toEntity(WeatherRequestDTO weatherRequestDTO, City city);

}
