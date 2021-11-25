package io.swagger.api;

import io.swagger.model.Fare;
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
public class FaresApiController implements FaresApi {

    private static final Logger log = LoggerFactory.getLogger(FaresApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FaresApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Fare> getFare(@NotNull @ApiParam(value = "airport code", required = true) @Valid @RequestParam(value = "origin_code", required = true) String originCode,@NotNull @ApiParam(value = "airport code", required = true) @Valid @RequestParam(value = "destination_code", required = true) String destinationCode,@ApiParam(value = "the requested resulting currency, supported ones are EUR and USD  (default: EUR)") @Valid @RequestParam(value = "currency", required = false) String currency) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Fare>(objectMapper.readValue("{\"empty\": false}", Fare.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Fare>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Fare>(HttpStatus.NOT_IMPLEMENTED);
    }

}
