package com.wipro.cabapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.cabapi.dto.CabDTO;
import com.wipro.cabapi.dto.CabDriverVO;
import com.wipro.cabapi.dto.Driver;
import com.wipro.cabapi.entity.Cab;
import com.wipro.cabapi.service.ICabService;

@RestController
@RequestMapping("/api/cabs")
public class CabRestController {

    @Autowired
    ICabService service;

    @PostMapping(value="/add", produces = "application/json", consumes = "application/json")
    public Cab addCab(@RequestBody CabDTO cabDTO) {
        return service.addCab(cabDTO);
    }

    @GetMapping(value="/get/{cabId}")
    public CabDTO getCabById(@PathVariable int cabId) {
        return service.getCabById(cabId);
    }

    @GetMapping("/getall")
    public List<Cab> getAllCabs() {
        return service.getAllCabs();
    }

    @GetMapping("/get/cab-driver/{cabId}")
    public CabDriverVO getCabAndDriverById(@PathVariable int cabId) {
        return service.getCabAndDriverById(cabId);
    }

    @PutMapping("/update/driver-by-cab")
    public String updateDriverByCab(@RequestBody Driver driver) {
        service.updateDriverByCab(driver);
        return "Updated driver information.";
    }
}
