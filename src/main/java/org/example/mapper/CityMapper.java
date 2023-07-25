package org.example.mapper;

import org.example.dao.entity.City;
import org.example.dao.entity.Country;
import org.example.model.dto.CityRequestDTO;
import org.example.model.dto.CityResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "cityRequestDTO.name")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    City toEntity(CityRequestDTO cityRequestDTO, Country country);

    CityResponseDTO toDTO(City city);

}

