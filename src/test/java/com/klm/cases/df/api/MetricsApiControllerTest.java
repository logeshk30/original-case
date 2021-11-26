package com.klm.cases.df.api;

import com.klm.cases.df.model.Metrics;
import com.klm.cases.df.service.MetricsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MetricsApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MetricsService metricsService;


    private static final String API_BASE = "/actuator";

    //@Test
    public void getMetricsBadRequestWithoutAcceptTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/httptrace")
                .header("Origin", ""))
                .andExpect(status().isBadRequest());
    }


    //@Test
    public void getMetricsExceptionTest() throws Exception {
        when(metricsService.getPerformanceMetrics()).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/httptrace")
                .header("Origin", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }


    //@Test
    public void getMetricsSuccessTest() throws Exception {

        when(metricsService.getPerformanceMetrics()).thenReturn(new Metrics());

        mockMvc.perform(MockMvcRequestBuilders.get(API_BASE + "/httptrace")
                .header("Origin", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
