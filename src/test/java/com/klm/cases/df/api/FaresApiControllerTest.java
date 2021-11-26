package com.klm.cases.df.api;


import com.klm.cases.df.model.AirportsResponse;
import com.klm.cases.df.model.Fare;
import com.klm.cases.df.service.FareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FaresApiControllerTest {

    private static final String API_BASE = "/api-v1";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FareService fareService;


    @Test
    public void getFaresBadRequestWithoutAcceptTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/fares")
                .header("Origin", "")
                .param("origin_code", "BBA")
                .param("destination_code", "SDJ"))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void getFaresExceptionTest() throws Exception {
        when(fareService.getCalculatedFare(any(), any(), any())).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/fares")
                .header("Origin", "")
                .param("origin_code", "BBA")
                .param("destination_code", "SDJ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }


    @Test
    public void getFaresSuccessTest() throws Exception {

        when(fareService.getCalculatedFare(any(), any(), any())).thenReturn(new Fare());

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/fares")
                .header("Origin", "")
                .param("origin_code", "BBA")
                .param("destination_code", "SDJ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
