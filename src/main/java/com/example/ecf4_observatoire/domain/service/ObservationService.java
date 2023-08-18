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

    public List<Observation> searchObservations(Long celestialObjectId, LocalDateTime date, Long userId) {
        if (celestialObjectId != null && date != null && userId != null) {
            return observationRepository.findByCelestialObject_IdAndObservationDateAndUserId(celestialObjectId, date, userId);
        } else if (celestialObjectId != null && date != null) {
            return observationRepository.findByCelestialObject_IdAndObservationDate(celestialObjectId, date);
        } else if (celestialObjectId != null && userId != null) {
            return observationRepository.findByCelestialObject_IdAndUserId(celestialObjectId, userId);
        } else if (date != null && userId != null) {
            return observationRepository.findByObservationDateAndUserId(date, userId);
        } else if (celestialObjectId != null) {
            return observationRepository.findByCelestialObject_Id(celestialObjectId);
        } else if (date != null) {
            return observationRepository.findByObservationDate(date);
        } else if (userId != null) {
            return observationRepository.findByUserId(userId);
        } else {
            return observationRepository.findAll();
        }
    }
}