package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.model.dto.CityRequestDTO;
import org.example.model.dto.CityResponseDTO;
import org.example.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CityResponseDTO> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/countries/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CityResponseDTO> getByCountry(@PathVariable Long id) {
        return cityService.getAllByCountry(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody CityRequestDTO cityRequestDto) {
        cityService.add(cityRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @Valid @RequestBody CityRequestDTO cityRequestDto) {
        cityService.update(id, cityRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

}
