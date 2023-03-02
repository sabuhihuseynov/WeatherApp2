package org.example.mapper;

import org.example.dto.CountryRequestDto;
import org.example.dto.CountryResponseDto;
import org.example.entity.Country;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface CountryMapper {

     CountryResponseDto toCountryResponseDto(Country country);

     Country toCountry(CountryRequestDto countryRequestDto);

}
