package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CityRequestDto;
import org.example.dto.CityResponseDto;
import org.example.entity.City;
import org.example.error.EntityNotFoundException;
import org.example.mapper.CityMapper;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityResponseDto> getAll() {
        return cityRepository.getAll();
    }

    public List<CityResponseDto> getAllByCountry(Integer id) {
        return cityRepository.findByCountryId(id);
    }


    public void add(CityRequestDto cityRequestDto) {
        City city = cityMapper.toCity(cityRequestDto);
        cityRepository.save(city);
    }

    public void update(Integer id, CityRequestDto cityRequestDto) {
        City city = cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("City"));
        city.setName(cityRequestDto.getName());
        cityRepository.save(city);
    }

    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

}
