package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CountryRequestDto;
import org.example.dto.CountryResponseDto;
import org.example.entity.Country;
import org.example.error.EntityNotFoundException;
import org.example.mapper.CountryMapper;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryResponseDto> getAll() {
        return countryRepository.findAll()
                .stream().map(countryMapper::toCountryResponseDto).collect(Collectors.toList());
    }

    public void add(CountryRequestDto countryRequestDto) {
        Country country = countryMapper.toCountry(countryRequestDto);
        countryRepository.save(country);
    }

    public void update(Integer id, CountryRequestDto countryRequestDto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country"));
        country.setName(countryRequestDto.getName());
        countryRepository.save(country);
    }

    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

}
