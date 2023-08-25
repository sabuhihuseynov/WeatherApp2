package org.example.dao.repository;

import org.example.dao.entity.HourlyWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourlyWeatherRepository extends JpaRepository<HourlyWeather, Long> {
}
