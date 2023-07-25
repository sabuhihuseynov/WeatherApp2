package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.entity.Country;
import org.example.dao.repository.CountryRepository;
import org.example.error.exceptions.NotFoundException;
import org.example.mapper.CountryMapper;
import org.example.model.consts.Messages;
import org.example.model.dto.CountryRequestDTO;
import org.example.model.dto.CountryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryResponseDTO> getAll() {
        log.info("Action.getAll.start");
        return countryRepository.findAll()
                .stream().map(countryMapper::toDTO).collect(Collectors.toList());
    }

    public void add(CountryRequestDTO countryRequestDto) {
        log.info("Action.add.start");
        Country country = countryMapper.toEntity(countryRequestDto);
        countryRepository.save(country);
        log.info("Action.add.end");
    }

    public void update(Long id, CountryRequestDTO countryRequestDto) {
        log.info("Action.update.start");
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Messages.COUNTRY_NOT_FOUND, Messages.COUNTRY_NOT_FOUND_MSG));
        country.setName(countryRequestDto.name());
        countryRepository.save(country);
        log.info("Action.update.end");
    }

    public void delete(Long id) {
        log.info("Action.delete.start");
        countryRepository.deleteById(id);
        log.info("Action.delete.end");
    }

}
