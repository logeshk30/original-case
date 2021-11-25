package com.klm.cases.df.service;

import com.klm.cases.df.model.AirportsResponse;
import com.klm.cases.df.model.Location;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.KlmApi;
import io.swagger.client.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    @Value("${travel.mock.service.url}")
    private String travelMockUrl;

    @Value("${mock.service.userName}")
    private String username;

    @Value("${mock.service.password}")
    private String password;

    @Autowired
    private KlmApi klmApi;


    public AirportsResponse getAirportsbyTerm(Integer size, Integer page, String lang, String term){
        ApiClient apiClient = Configuration.getDefaultApiClient();
        apiClient.setBasePath(travelMockUrl);
        apiClient.setUsername(username);
        apiClient.setPassword(password);

        io.swagger.client.model.AirportsResponse airportsResponse;
        try {
            airportsResponse = klmApi.getAirports(size, page, lang, term);
        } catch (ApiException e) {
            throw new RuntimeException("Internal Server Error");
        }
        return convertDAOtoDTO(airportsResponse);
    }


    private AirportsResponse convertDAOtoDTO(io.swagger.client.model.AirportsResponse airportsResponse){
        if (airportsResponse == null) return null;
        List<io.swagger.client.model.Location> locations = airportsResponse.getEmbedded().getLocations();
        Page pageInfo = airportsResponse.getPage();

        AirportsResponse theAirportsResponse = new AirportsResponse();
        theAirportsResponse.setPage(convertPageDAOtoDTO(pageInfo));
        List<Location> list = new ArrayList<>();
        for (io.swagger.client.model.Location location : locations){
            Location theLocation = convertLocationDAOtoDTO(location);
            list.add(theLocation);
        }
        theAirportsResponse.setLocations(list);
        return theAirportsResponse;
    }

    private Location convertLocationDAOtoDTO(io.swagger.client.model.Location location){
        if (location == null) return null;
        Location theLocation = new Location();
        theLocation.setCode(location.getCode());
        theLocation.setName(location.getName());
        theLocation.setDescription(location.getDescription());
        return theLocation;
    }

    private com.klm.cases.df.model.Page convertPageDAOtoDTO(Page page){
        if (page == null) return null;
        com.klm.cases.df.model.Page pageInfo = new com.klm.cases.df.model.Page();
        pageInfo.setNumber(page.getNumber());
        pageInfo.setSize(page.getSize());
        pageInfo.setTotalElements(page.getTotalElements());
        pageInfo.setTotalPages(page.getTotalPages());
        return pageInfo;
    }
}
