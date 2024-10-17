package com.wipro.cabapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.cabapi.dto.CabDTO;
import com.wipro.cabapi.dto.CabDriverVO;
import com.wipro.cabapi.dto.Driver;
import com.wipro.cabapi.entity.Cab;
import com.wipro.cabapi.repository.CabRepository;

@Service
public class CabServiceImp implements ICabService {

    @Autowired
    CabRepository repo;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Cab addCab(CabDTO cabDTO) {

        Cab cab = new Cab();
        cab.setCabId(cabDTO.getCabId());
        cab.setCabName(cabDTO.getCabName());
        cab.setDateOfBook(cabDTO.getDateOfBook());
        cab.setDriverId(cabDTO.getDriverId());

        return repo.save(cab);
    }

    @Override
    public CabDTO getCabById(int cabId) {

        Cab cab = repo.findById(cabId).orElse(null);

        CabDTO dto = new CabDTO();
        dto.setCabId(cab.getCabId());
        dto.setCabName(cab.getCabName());
        dto.setDateOfBook(cab.getDateOfBook());
        dto.setDriverId(cab.getDriverId());

        return dto;
    }

    @Override
    public List<Cab> getAllCabs() {
        return repo.findAll();
    }

    @Override
    public CabDriverVO getCabAndDriverById(int cabId) {

        // step1
        CabDTO cab = getCabById(cabId);

        int driverId = cab.getDriverId();

        // step2: call rest api from driver microservice
        Driver driver = restTemplate.getForObject("http://localhost:8282/api/drivers/get/" + driverId, Driver.class);

        CabDriverVO cabDriverVO = new CabDriverVO();
        cabDriverVO.setCab(cab);
        cabDriverVO.setDriver(driver);

        return cabDriverVO;
    }

    @Override
    public void updateDriverByCab(Driver driver) {
        restTemplate.put("http://localhost:8282/api/drivers/update", driver);
        System.out.println("Updated driver information from cab MS");
    }
}
