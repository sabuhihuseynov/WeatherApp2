package org.example.mapper;

import org.example.dto.CountryRequestDto;
import org.example.dto.CountryResponseDto;
import org.example.entity.Country;
import org.springframework.stereotype.Component;


@Component

public class CountryMapper {

    public CountryResponseDto toCountryResponseDto(Country country) {
        CountryResponseDto countryResponseDto = new CountryResponseDto();
        countryResponseDto.setId(country.getId());
        countryResponseDto.setName(country.getName());
        return countryResponseDto;
    }

    public Country toCountry(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        country.setName(countryRequestDto.getName());
        return country;
    }

}
