package io.swagger.api;

import io.swagger.model.AirportsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")

@Controller
public class AirportsApiController implements AirportsApi {

    private static final Logger log = LoggerFactory.getLogger(AirportsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AirportsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AirportsResponse> getAirports(@ApiParam(value = "the size of the result") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "the page to be selected in the paged response") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "the language, supported ones are nl and en") @Valid @RequestParam(value = "lang", required = false) String lang,@ApiParam(value = "A search term that searches through code, name and description.") @Valid @RequestParam(value = "term", required = false) String term) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AirportsResponse>(objectMapper.readValue("{\"empty\": false}", AirportsResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AirportsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AirportsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
