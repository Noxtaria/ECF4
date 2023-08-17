package com.example.ecf4_observatoire.application.controllers;

import com.example.ecf4_observatoire.domain.service.ObservationService;
import com.example.ecf4_observatoire.domain.model.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


import java.util.List;

@RestController
@RequestMapping("/observations")
public class ObservationController {
    private final ObservationService observationService;

    @Autowired
    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

    @PostMapping
    public ResponseEntity<Observation> createObservation(@RequestBody Observation observation) {
        Observation createdObservation = observationService.createObservation(observation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdObservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observation> getObservationById(@PathVariable Long id) {
        Observation observation = observationService.getObservationById(id);
        return ResponseEntity.ok(observation);
    }
    
}
