package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dto.CityRequestDto;
import org.example.dto.CityWeatherDto;
import org.example.entity.City;
import org.example.entity.Country;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CityMapper {

    private final CountryRepository countryRepository;

    public City toCity(CityRequestDto cityRequestDto) {
        Country country = countryRepository.findById(cityRequestDto.getCountryId()).orElseThrow();
        City city = new City();
        city.setName(cityRequestDto.getName());
        city.setCountry(country);
        return city;
    }

    public List<City> covertCityWeatherDTOtoCityList(List<CityWeatherDto> cityWeatherDtoList) {
        List<City> cities = new ArrayList<>();
        for (CityWeatherDto cityWeatherDto : cityWeatherDtoList) {
            City city = new City();
            city.setId(cityWeatherDto.getCityId());
            city.setName(cityWeatherDto.getCityName());
            if (cities.contains(city)) {
                continue;
            }
            cities.add(city);
        }
        return cities;
    }

}
