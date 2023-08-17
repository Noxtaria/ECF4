package com.example.ecf4_observatoire.infrastructure.repository;

import com.example.ecf4_observatoire.domain.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {

}
