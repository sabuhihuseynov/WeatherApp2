package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CountryRequestDto;
import org.example.dto.CountryResponseDto;
import org.example.service.CountryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<CountryResponseDto> getAll() {
        return countryService.getAll();
    }

    @PostMapping
    public void add(@Valid @RequestBody CountryRequestDto countryRequestDto) {
        countryService.add(countryRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody CountryRequestDto countryRequestDto) {
        countryService.update(id, countryRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        countryService.deleteById(id);
    }
}
