import { Component } from '@angular/core';
import { VehicleService } from 'src/app/service/vehicle.service';
import { Vehicle } from 'src/app/model/vehicle';
@Component({
  selector: 'app-update-vehicle',
  templateUrl: './updatevehicle.component.html',
  styleUrls: ['./updatevehicle.component.css']
})
export class UpdatevehicleComponent {

  constructor(private vehicleService: VehicleService) {}

  updateVehicle(data: Vehicle) {
    this.vehicleService.update(data)
      .subscribe(
        (vehicle) => {
          console.log('Updated Vehicle is: ' + vehicle);
          alert('Vehicle updated successfully!');
        },
        (error) => {
          console.error('Error updating vehicle:', error);
          alert('Error updating vehicle.');
        }
      );
  }
}
