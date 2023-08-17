package com.example.ecf4_observatoire.infrastructure.repository;

import com.example.ecf4_observatoire.domain.model.CelestialObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelestialObjectRepository extends JpaRepository<CelestialObject, Long> {
}
