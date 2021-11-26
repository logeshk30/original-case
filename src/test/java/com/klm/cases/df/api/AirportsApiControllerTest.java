package com.klm.cases.df.api;

import com.klm.cases.df.model.AirportsResponse;
import com.klm.cases.df.service.AirportService;
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
public class AirportsApiControllerTest {


    private static final String API_BASE = "/api-v1";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportService airportService;


    @Test
    public void getAirportsBadRequestWithoutAcceptTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/airports")
                .header("Origin", "")
                .param("term", "BB"))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void getAirportsExceptionTest() throws Exception {
        when(airportService.getAirportsbyTerm(any(), any(), any(), any())).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/airports")
                .header("Origin", "")
                .param("term", "BB")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }


    @Test
    public void getAirportsSuccessTest() throws Exception {

        when(airportService.getAirportsbyTerm(any(), any(), any(), any())).thenReturn(new AirportsResponse());

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/airports")
                .header("Origin", "")
                .param("term", "BB")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
