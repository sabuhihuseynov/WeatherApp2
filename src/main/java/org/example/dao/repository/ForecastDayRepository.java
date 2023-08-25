package org.example.dao.repository;

import org.example.dao.entity.ForecastDay;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ForecastDayRepository extends JpaRepository<ForecastDay, Long> {

    @EntityGraph(attributePaths = {"day", "astro", "hourlyWeatherList"})
    List<ForecastDay> getForecastDayByLocation_IdAndDateGreaterThan(Long locationId, LocalDate date);
}
