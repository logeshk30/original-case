package com.klm.cases.df.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klm.cases.df.model.AirportsResponse;
import com.klm.cases.df.service.AirportService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")

@Controller
public class AirportsApiController implements AirportsApi {

    private static final Logger log = LoggerFactory.getLogger(AirportsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private AirportService airportService;

    @org.springframework.beans.factory.annotation.Autowired
    public AirportsApiController(ObjectMapper objectMapper, HttpServletRequest request, AirportService airportService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.airportService = airportService;
    }

    public ResponseEntity<AirportsResponse> getAirports(@ApiParam(value = "the size of the result") @Valid @RequestParam(value = "size", required = false) Integer size, @ApiParam(value = "the page to be selected in the paged response") @Valid @RequestParam(value = "page", required = false) Integer page, @ApiParam(value = "the language, supported ones are nl and en") @Valid @RequestParam(value = "lang", required = false) String lang, @ApiParam(value = "A search term that searches through code, name and description.") @Valid @RequestParam(value = "term", required = false) String term) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                AirportsResponse airportsResponse = airportService.getAirportsbyTerm(size, page, lang, term);
                return new ResponseEntity<AirportsResponse>(airportsResponse, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<AirportsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<AirportsResponse>(HttpStatus.BAD_REQUEST);
    }

}
