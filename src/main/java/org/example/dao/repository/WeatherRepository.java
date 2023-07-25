package org.example.dao.repository;

import org.example.dao.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findWeatherByCityId(Long cityId);

    List<Weather> findAllByDate(LocalDate localDate);

}
