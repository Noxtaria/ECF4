package com.example.ecf4_observatoire.domain.service;

import com.example.ecf4_observatoire.domain.model.Observation;
import com.example.ecf4_observatoire.domain.repository.ObservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ObservationService {
    private final ObservationRepository observationRepository;

    @Autowired
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public List<Observation> getAllObservations() {
        return observationRepository.findAll();
    }

    public Observation getObservationById(Long id) {
        return observationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Observation not found with id: " + id));
    }

    public Observation createObservation(Observation observation) {
        observation.setObservationDate(LocalDateTime.now());
        return observationRepository.save(observation);
    }
}