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
public class FareServiceTest {

    @InjectMocks
    private FareService fareService;

    @Mock
    private KlmApi klmApi;


    @Test
    public void getFaresFromMockExceptionTest() throws ApiException {
        ReflectionTestUtils.setField(fareService, "travelMockUrl", "http://localhost:8080");
        ReflectionTestUtils.setField(fareService, "username", "user");
        ReflectionTestUtils.setField(fareService, "password", "secret123");

        when(fareService.getCalculatedFare(any(), any(), any())).thenThrow(new ApiException());

        Assertions.assertThrows(RuntimeException.class, () -> {
            fareService.getCalculatedFare("BBA", "SDJ", "USD");
        });
    }
}
