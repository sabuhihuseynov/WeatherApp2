package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CityRequestDto;
import org.example.dto.CityResponseDto;
import org.example.service.CityService;
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
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityResponseDto> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/countries/{id}")
    public List<CityResponseDto> getByCountry(@PathVariable Integer id) {
        return cityService.getAllByCountry(id);
    }

    @PostMapping
    public void add(@Valid @RequestBody CityRequestDto cityRequestDto) {
        cityService.add(cityRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody CityRequestDto cityRequestDto) {
        cityService.update(id, cityRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cityService.deleteById(id);
    }

}
