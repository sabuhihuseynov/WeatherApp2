package org.example.dao.repository;

import org.example.dao.entity.WeatherCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherConditionRepository extends JpaRepository<WeatherCondition, Long> {
}
