
package com.vehiclemanagement.repository;

import com.vehiclemanagement.entity.Vehicle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	Vehicle findByVehicleName(String vehicleName);
	
}
