package org.example.service;

import org.example.dto.CityRequestDto;
import org.example.dto.CityResponseDto;

import java.util.List;

public interface CityService {

    List<CityResponseDto> getAll();

    List<CityResponseDto> getAllByCountry(Integer id);

    void add(CityRequestDto cityRequestDto);

    void update(Integer id, CityRequestDto cityRequestDto);

    void deleteById(Integer id);

}
