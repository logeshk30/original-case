package com.klm.cases.df.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.klm.cases.df.model.Metrics;
import com.klm.cases.df.service.MetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")

@Controller
public class MetricsApiController implements MetricsApi {

    private static final Logger log = LoggerFactory.getLogger(MetricsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private MetricsService metricsService;

    @org.springframework.beans.factory.annotation.Autowired
    public MetricsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;

    }

    public ResponseEntity<Metrics> getMetrics() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Metrics metrics = metricsService.getPerformanceMetrics();
                return new ResponseEntity<Metrics>(metrics, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<Metrics>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Metrics>(HttpStatus.BAD_REQUEST);
    }

}
