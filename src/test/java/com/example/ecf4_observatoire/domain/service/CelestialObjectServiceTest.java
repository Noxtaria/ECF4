package com.example.ecf4_observatoire.domain.service;

import com.example.ecf4_observatoire.domain.model.CelestialObject;
import com.example.ecf4_observatoire.domain.repository.CelestialObjectRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CelestialObjectServiceTest {
    @Mock
    private CelestialObjectRepository celestialObjectRepository;

    @InjectMocks
    private CelestialObjectService celestialObjectService;

    @Test
    public void testGetAllCelestialObjects() {
        CelestialObject object = new CelestialObject();
        object.setId(1L);
        object.setName("Sample Object");

        when(celestialObjectRepository.findAll()).thenReturn(Collections.singletonList(object));

        List<CelestialObject> objects = celestialObjectService.getAllCelestialObjects();
        assertEquals(1, objects.size());
        assertEquals("Sample Object", objects.get(0).getName());

        verify(celestialObjectRepository, times(1)).findAll();
    }

}