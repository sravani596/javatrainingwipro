package com.vehiclemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclemanagement.entity.Vehicle;
import com.vehiclemanagement.repository.VehicleRepository;
@Service
public class VehicleServiceImp implements IVehicleService {
	

    @Autowired
    private VehicleRepository vehicleRepository;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void deleteVehicleById(int vehicleId) {
		 vehicleRepository.deleteById(vehicleId);

	}

	@Override
	public List<Vehicle> getAllVehicles() {
		
		 return vehicleRepository.findAll();
	}

	@Override
	public Optional<Vehicle> getVehicleById(int vehicleId) {
		
		return vehicleRepository.findById(vehicleId);
	}

	@Override
    public Vehicle getByVehicleName(String vehicleName) {
        return vehicleRepository.findByVehicleName(vehicleName);
    }

}
