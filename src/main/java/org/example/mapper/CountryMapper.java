package org.example.mapper;

import org.example.dao.entity.Country;
import org.example.model.dto.CountryRequestDTO;
import org.example.model.dto.CountryResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryResponseDTO toDTO(Country country);

    Country toEntity(CountryRequestDTO countryRequestDto);

}
