package org.example.repository;

import org.example.dto.CityResponseDto;
import org.example.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "select new org.example.dto.CityResponseDto(c.id,c.name) " +
            "from City as c")
    List<CityResponseDto> getAll();

    @Query(value = "select new org.example.dto.CityResponseDto(c.id,c.name)\n" +
            "from City as c\n" +
            "where c.country.id = ?1")
    List<CityResponseDto> findByCountryId(Integer id);

}
