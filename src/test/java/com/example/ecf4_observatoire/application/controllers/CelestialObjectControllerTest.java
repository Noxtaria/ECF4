package com.example.ecf4_observatoire.application.controllers;

import com.example.ecf4_observatoire.domain.model.CelestialObject;
import com.example.ecf4_observatoire.domain.service.CelestialObjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CelestialObjectController.class)
public class CelestialObjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CelestialObjectService celestialObjectService;

    @Test
    public void testGetAllCelestialObjects() throws Exception {
        CelestialObject object = new CelestialObject();
        object.setId(1L);
        object.setName("Sample Object");

        when(celestialObjectService.getAllCelestialObjects()).thenReturn(Collections.singletonList(object));

        ResultActions result = mockMvc.perform(get("/celestial-objects"));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Sample Object"));

        verify(celestialObjectService, times(1)).getAllCelestialObjects();
    }
}