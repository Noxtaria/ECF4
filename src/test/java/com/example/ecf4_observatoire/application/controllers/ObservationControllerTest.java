package com.example.ecf4_observatoire.application.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.ecf4_observatoire.domain.model.Observation;
import com.example.ecf4_observatoire.domain.service.ObservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

public class ObservationControllerTest {

    @Mock
    private ObservationService observationService;

    @InjectMocks
    private ObservationController observationController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(observationController).build();
    }

    @Test
    public void testGetAllObservations() throws Exception {
        List<Observation> observations = new ArrayList<>();
        observations.add(new Observation(1L, "Observation 1"));
        observations.add(new Observation(2L, "Observation 2"));

        when(observationService.getAllObservations()).thenReturn(observations);

        mockMvc.perform(get("/observations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].description").value("Observation 1"))
                .andExpect(jsonPath("$[1].description").value("Observation 2"));
    }

    @Test
    public void testGetObservationById() throws Exception {
        Observation observation = new Observation(1L, "Test Observation");

        when(observationService.getObservationById(1L)).thenReturn(observation);

        mockMvc.perform(get("/observations/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Test Observation"));
    }

    @Test
    public void testCreateObservation() throws Exception {
        Observation observation = new Observation();
        observation.setDescription("New Observation");

        when(observationService.createObservation(any())).thenReturn(observation);

        mockMvc.perform(post("/observations")
                        .contentType("application/json")
                        .content("{\"description\":\"New Observation\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.description").value("New Observation"));
    }

}
