package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.City;
import org.example.dao.entity.Country;
import org.example.dao.repository.CityRepository;
import org.example.error.exceptions.NotFoundException;
import org.example.mapper.CityMapper;
import org.example.model.consts.Messages;
import org.example.model.dto.CityRequestDTO;
import org.example.model.dto.CityResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final CityMapper mapper;

    @Override
    public List<CityResponseDTO> getAll() {
        log.info("Action.getAll.start");
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public List<CityResponseDTO> getAllByCountry(Long id) {
        log.info("Action.getAllByCountry.start");
        return repository.findCitiesByCountryId(id)
                .stream().map(mapper::toDTO)
                .toList();
    }

    @Override
    public void add(CityRequestDTO cityRequestDto) {
        log.info("Action.add.start");
        Country country = new Country();
        country.setId(cityRequestDto.countryId());
        City city = mapper.toEntity(cityRequestDto, country);
        repository.save(city);
        log.info("Action.add.end");
    }

    @Override
    public void update(Long id, CityRequestDTO cityRequestDto) {
        log.info("Action.update.start");
        City city = repository.findById(id).orElseThrow(() -> new NotFoundException(
                Messages.CITY_NOT_FOUND, Messages.CITY_NOT_FOUND_MSG));
        city.setName(cityRequestDto.name());
        repository.save(city);
        log.info("Action.update.end");
    }

    @Override
    public void delete(Long id) {
        log.info("Action.delete.start");
        repository.deleteById(id);
        log.info("Action.delete.end");
    }

}
