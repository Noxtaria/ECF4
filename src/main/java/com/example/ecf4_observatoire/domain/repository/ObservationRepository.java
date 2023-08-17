package com.example.ecf4_observatoire.domain.repository;

import com.example.ecf4_observatoire.domain.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {

}
