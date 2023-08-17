package com.example.ecf4_observatoire.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CelestialObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "celestialObject", cascade = CascadeType.ALL)
    private List<Observation> observations = new ArrayList<>();

    public CelestialObject() {
    }

    public CelestialObject(Long id, String name, List<Observation> observations) {
        this.id = id;
        this.name = name;
        this.observations = observations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "CelestialObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", observations=" + observations +
                '}';
    }
}
