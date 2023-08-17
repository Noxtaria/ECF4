package com.example.ecf4_observatoire.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime observationDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "celestial_object_id")
    private CelestialObject celestialObject;

    public Observation() {
    }

    public Observation(Long id, LocalDateTime observationDate, String description, CelestialObject celestialObject) {
        this.id = id;
        this.observationDate = observationDate;
        this.description = description;
        this.celestialObject = celestialObject;
    }

    public Observation(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getObservationDate() {
        return observationDate;
    }

    public void setObservationDate(LocalDateTime observationDate) {
        this.observationDate = observationDate;
    }

    public String getDescription() {
        return description;
    }

    public CelestialObject getCelestialObject() {
        return celestialObject;
    }

    public void setCelestialObject(CelestialObject celestialObject) {
        this.celestialObject = celestialObject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "id=" + id +
                ", observationDate=" + observationDate +
                ", description='" + description + '\'' +
                ", celestialObject=" + celestialObject +
                '}';
    }
}
