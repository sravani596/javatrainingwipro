package com.vehiclemanagement.service;

import com.vehiclemanagement.entity.Vehicle;
import java.util.List;
import java.util.Optional;

public interface IVehicleService {
	
   public  Vehicle addVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
    
    void deleteVehicleById(int vehicleId);
    
    
    List<Vehicle> getAllVehicles();
    Vehicle getByVehicleName(String vehicleName);
    
    
    Optional<Vehicle> getVehicleById(int vehicleId);
}
