package com.example.ecf4_observatoire.application.controllers;

import com.example.ecf4_observatoire.domain.service.CelestialObjectService;
import com.example.ecf4_observatoire.domain.model.CelestialObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/celestial-objects")
public class CelestialObjectController {
    private final CelestialObjectService celestialObjectService;

    @Autowired
    public CelestialObjectController(CelestialObjectService celestialObjectService) {
        this.celestialObjectService = celestialObjectService;
    }

    @GetMapping
    public ResponseEntity<List<CelestialObject>> getAllCelestialObjects() {
        List<CelestialObject> objects = celestialObjectService.getAllCelestialObjects();
        return ResponseEntity.ok(objects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelestialObject> getCelestialObjectById(@PathVariable Long id) {
        CelestialObject object = celestialObjectService.getCelestialObjectById(id);
        return ResponseEntity.ok(object);
    }

}