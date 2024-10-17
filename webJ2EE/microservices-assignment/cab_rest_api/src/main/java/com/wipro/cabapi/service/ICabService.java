package com.wipro.cabapi.service;

import java.util.List;

import com.wipro.cabapi.dto.CabDTO;
import com.wipro.cabapi.dto.CabDriverVO;
import com.wipro.cabapi.dto.Driver;
import com.wipro.cabapi.entity.Cab;

public interface ICabService {

    public Cab addCab(CabDTO cabDTO);
    
    public CabDTO getCabById(int cabId);
        
    public List<Cab> getAllCabs();
    
    public CabDriverVO getCabAndDriverById(int cabId);

    public void updateDriverByCab(Driver driver);
    
}
