package org.afs.pakinglot.domain.controller;

import org.afs.pakinglot.domain.dto.FetchRequestDto;
import org.afs.pakinglot.domain.dto.ParkRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllParkingLots() throws Exception {
        mockMvc.perform(get("/parking-lot"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("The Plaza Park")))
                .andExpect(jsonPath("$[1].name", is("City Mall Garage")))
                .andExpect(jsonPath("$[2].name", is("Office Tower Parking")));
    }

    @Test
    public void testParkCar() throws Exception {
        ParkRequestDto parkRequest = new ParkRequestDto("NEW123", 0);
        mockMvc.perform(post("/parking-lot/park")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"plateNumber\":\"NEW123\",\"strategyIndex\":0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.plateNumber", is("NEW123")))
                .andExpect(jsonPath("$.position", is(notNullValue())))
                .andExpect(jsonPath("$.parkingLot", is(notNullValue())));
    }

    @Test
    public void testFetchCar() throws Exception {
        FetchRequestDto fetchRequest = new FetchRequestDto("CX23123", 1, 1);
        mockMvc.perform(post("/parking-lot/fetch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"plateNumber\":\"CX23123\",\"position\":1,\"parkingLot\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.plateNumber", is("CX23123")));
    }
}