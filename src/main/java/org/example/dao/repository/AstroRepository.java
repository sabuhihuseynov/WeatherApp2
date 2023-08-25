package org.example.dao.repository;

import org.example.dao.entity.Astro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstroRepository extends JpaRepository<Astro, Long> {
}
