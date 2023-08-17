package com.example.ecf4_observatoire.domain.service;

import com.example.ecf4_observatoire.domain.model.CelestialObject;
import com.example.ecf4_observatoire.domain.repository.CelestialObjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelestialObjectService {
    private final CelestialObjectRepository celestialObjectRepository;

    @Autowired
    public CelestialObjectService(CelestialObjectRepository celestialObjectRepository) {
        this.celestialObjectRepository = celestialObjectRepository;
    }

    public List<CelestialObject> getAllCelestialObjects() {
        return celestialObjectRepository.findAll();
    }

    public CelestialObject getCelestialObjectById(Long id) {
        return celestialObjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CelestialObject not found with id: " + id));
    }

}