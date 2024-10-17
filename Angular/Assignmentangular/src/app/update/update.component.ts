import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../vehicle/vehicle.service';
import { Vehicle } from '../vehicle/vehicle';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  vehicle: Vehicle = {
    id: 0,
    vno: '',
    vname: '',
    price: 0,
    purchasedate: ''
  };

  constructor(private vehicleService: VehicleService) {}

  ngOnInit(): void {
    // Fetch the vehicle details or initialize here
  }

  updateVehicle(): void {
    // Ensure vehicle.id is valid and being used
    if (this.vehicle.id) {
      this.vehicleService.updateVehicle(this.vehicle.id, this.vehicle).subscribe(
        (response) => {
          console.log('Vehicle updated successfully!', response);
        },
        (error) => {
          console.error('Error updating vehicle:', error);
        }
      );
    } else {
      console.error('Vehicle ID is not set, unable to update the vehicle');
    }
  }
  
  
}
