package com.klm.cases.df.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.klm.cases.df.model.Fare;
import com.klm.cases.df.service.FareService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")

@Controller
public class FaresApiController implements FaresApi {

    private static final Logger log = LoggerFactory.getLogger(FaresApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private FareService fareService;

    @org.springframework.beans.factory.annotation.Autowired
    public FaresApiController(ObjectMapper objectMapper, HttpServletRequest request, FareService fareService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.fareService = fareService;
    }

    public ResponseEntity<Fare> getFare(@NotNull @ApiParam(value = "airport code", required = true) @Valid @RequestParam(value = "origin_code", required = true) String originCode, @NotNull @ApiParam(value = "airport code", required = true) @Valid @RequestParam(value = "destination_code", required = true) String destinationCode, @ApiParam(value = "the requested resulting currency, supported ones are EUR and USD  (default: EUR)") @Valid @RequestParam(value = "currency", required = false) String currency) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Fare fare = fareService.getCalculatedFare(originCode, destinationCode, currency);
                return new ResponseEntity<Fare>(fare, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<Fare>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Fare>(HttpStatus.BAD_REQUEST);
    }

}
