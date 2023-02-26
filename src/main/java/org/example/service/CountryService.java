package org.example.service;

import org.example.dto.CountryRequestDto;
import org.example.dto.CountryResponseDto;

import java.util.List;

public interface CountryService {

    List<CountryResponseDto> getAll();

    void add(CountryRequestDto countryRequestDto);

    void update(Integer id, CountryRequestDto countryRequestDto);

    void deleteById(Integer id);

}
