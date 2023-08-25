package org.example.dao.repository;

import org.example.dao.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByCityName(String name);

}
