package org.example.service;


import org.example.model.dto.CountryRequestDTO;
import org.example.model.dto.CountryResponseDTO;

import java.util.List;

public interface CountryService {

    List<CountryResponseDTO> getAll();

    void add(CountryRequestDTO countryRequestDto);

    void update(Long id, CountryRequestDTO countryRequestDto);

    void delete(Long id);

}
