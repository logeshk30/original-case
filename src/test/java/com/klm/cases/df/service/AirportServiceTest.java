package com.klm.cases.df.service;

import io.swagger.client.ApiException;
import io.swagger.client.api.KlmApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {


    @InjectMocks
    private AirportService airportService;

    @Mock
    private KlmApi klmApi;


    @Test
    public void getAirportsFromMockExceptionTest() throws ApiException {
        ReflectionTestUtils.setField(airportService, "travelMockUrl", "http://localhost:8080");
        ReflectionTestUtils.setField(airportService, "username", "user");
        ReflectionTestUtils.setField(airportService, "password", "secret123");

        when(airportService.getAirportsbyTerm(any(), any(), any(), any())).thenThrow(new ApiException());

        Assertions.assertThrows(RuntimeException.class, () -> {
            airportService.getAirportsbyTerm(null, null, null, "BBA");
        });
    }
}
