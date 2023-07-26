package org.example.dao.repository;

import org.example.dao.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findCitiesByCountryId(Long countryId);

}
