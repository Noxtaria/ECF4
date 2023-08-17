package com.example.ecf4_observatoire.domain.service;

import com.example.ecf4_observatoire.domain.model.Observation;
import com.example.ecf4_observatoire.domain.repository.ObservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ObservationServiceTest {

    @Mock
    private ObservationRepository observationRepository;

    @InjectMocks
    private ObservationService observationService;

    @Test
    public void testGetObservationById() {
        Observation observation = new Observation();
        observation.setId(1L);
        observation.setDescription("Test Observation");

        when(observationRepository.findById(1L)).thenReturn(Optional.of(observation));

        Observation result = observationService.getObservationById(1L);

        assertEquals("Test Observation", result.getDescription());
    }

}