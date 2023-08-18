package com.example.ecf4_observatoire.domain.repository;

import com.example.ecf4_observatoire.domain.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {

    List<Observation> findByCelestialObject_IdAndUserId(Long celestialObjectId, Long userId);

    List<Observation> findByCelestialObject_IdAndObservationDateAndUserId(Long celestialObjectId, LocalDateTime date, Long userId);

    List<Observation> findByCelestialObject_IdAndObservationDate(Long celestialObjectId, LocalDateTime date);

    List<Observation> findByObservationDateAndUserId(LocalDateTime date, Long userId);

    List<Observation> findByCelestialObject_Id(Long celestialObjectId);

    List<Observation> findByObservationDate(LocalDateTime date);

    List<Observation> findByUserId(Long userId);
}
