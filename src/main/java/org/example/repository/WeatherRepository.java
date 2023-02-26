package org.example.repository;

import org.example.dto.CityWeatherDto;
import org.example.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Query(value = "select new org.example.dto.CityWeatherDto (w.id,w.date,w.temperature,w.time,w.type,w.windSpeed,c.id,c.name)\n" +
            "from Weather as w\n" +
            "inner join City as c\n" +
            "on w.city = c\n" +
            "where w.city.id= :cityId ")
    List<CityWeatherDto> getWeatherAndCityByCityId(Integer cityId);

    @Query(value = "select new org.example.dto.CityWeatherDto (w.id,w.date,w.temperature,w.time,w.type,w.windSpeed,c.id,c.name)\n" +
            "from City as c\n" +
            "inner join Weather as w\n" +
            "on w.city=c")
    List<CityWeatherDto> getAllWithCities();

}
