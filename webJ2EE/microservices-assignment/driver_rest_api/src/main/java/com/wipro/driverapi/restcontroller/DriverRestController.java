package com.wipro.driverapi.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.driverapi.dto.DriverDTO;
import com.wipro.driverapi.entity.Driver;
import com.wipro.driverapi.exception.DriverNotFoundException;
import com.wipro.driverapi.service.IDriverService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {

    Logger logger = LoggerFactory.getLogger(DriverRestController.class);

    @Autowired
    IDriverService service;

    @PostMapping("/add")
    public Driver addDriver(@RequestBody DriverDTO driverDTO) {
        return service.addDriver(driverDTO);
    }

    @PutMapping(value="/update", consumes = "application/json")
    public Driver updateDriver(@RequestBody DriverDTO driverDTO) {
        return service.updateDriver(driverDTO);
    }

    @GetMapping("/get/{driverId}")
    public DriverDTO getById(@PathVariable @Valid @Min(1) int driverId) throws DriverNotFoundException {

        DriverDTO driverDTO = service.getById(driverId);

        if (driverDTO.getDriverId() == 0) {
            throw new DriverNotFoundException(HttpStatus.BAD_REQUEST, "Driver Not Found for DriverId : " + driverId);
        }

        return driverDTO;
    }

    @GetMapping("/getall")
    public List<Driver> getAllDrivers() {
        logger.debug("I am debug");
        logger.info("I am info");
        logger.warn("I am warning");
        logger.error("I am error");

        return service.getAllDrivers();
    }

    @GetMapping("/div/{a}/{b}")
    public int div(@PathVariable int a, @PathVariable int b) {
        return a / b;
    }

    @ExceptionHandler({DriverNotFoundException.class})
    public ResponseEntity<String> handleDriverNotFoundExp(DriverNotFoundException de) {
        return new ResponseEntity<String>(de.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
