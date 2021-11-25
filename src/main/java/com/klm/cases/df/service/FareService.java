package com.klm.cases.df.service;

import com.klm.cases.df.model.Fare;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.KlmApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FareService {

    @Value("${travel.mock.service.url}")
    private String travelMockUrl;

    @Value("${mock.service.userName}")
    private String username;

    @Value("${mock.service.password}")
    private String password;

    @Autowired
    private KlmApi klmApi;


    private static final Logger log = LoggerFactory.getLogger(FareService.class);

    public Fare getCalculatedFare(String originCode, String destinationCode, String currency){
        ApiClient apiClient = Configuration.getDefaultApiClient();
        apiClient.setBasePath(travelMockUrl);
        apiClient.setUsername(username);
        apiClient.setPassword(password);
        io.swagger.client.model.Fare fare;
        try {
            fare  = klmApi.getFare(originCode, destinationCode, currency);
        } catch (ApiException e) {
            throw new RuntimeException("Internal Server Error");
        }
        if (fare == null){
            return null;
        }
        return convertDAOtoDTO(fare);
    }

    private Fare convertDAOtoDTO(io.swagger.client.model.Fare fare){
        Fare theFare = new Fare();
        theFare.setAmount(fare.getAmount());
        theFare.setCurrency(fare.getCurrency());
        theFare.setOrigin(fare.getOrigin());
        theFare.setDestination(fare.getDestination());
        return theFare;
    }
}
