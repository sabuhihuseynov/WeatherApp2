package org.example.service;

import org.example.model.dto.CityRequestDTO;
import org.example.model.dto.CityResponseDTO;

import java.util.List;

public interface CityService {

    List<CityResponseDTO> getAll();

    List<CityResponseDTO> getAllByCountry(Long id);

    void add(CityRequestDTO cityRequestDto);

    void update(Long id, CityRequestDTO cityRequestDto);

    void delete(Long id);

}
