package com.klm.cases.df.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.klm.cases.df.model.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")

@Controller
public class MetricsApiController implements MetricsApi {

    private static final Logger log = LoggerFactory.getLogger(MetricsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MetricsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Metrics> getMetrics() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Metrics>(objectMapper.readValue("{\"empty\": false}", Metrics.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Metrics>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Metrics>(HttpStatus.NOT_IMPLEMENTED);
    }

}
