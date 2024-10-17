import { Component } from '@angular/core';
import { Vehicle } from 'src/app/model/vehicle';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-addvehicle',
  templateUrl: './addvehicle.component.html',
  styleUrls: ['./addvehicle.component.css']
})
export class AddvehicleComponent {

  constructor(private vehicleService: VehicleService) {}

  insertVehicle(data: Vehicle) {
    this.vehicleService.insert(data)
      .subscribe(
        (vehicle) => { console.log('Added Vehicle is: ' + vehicle);
          alert('vehicle added successfully');
         }
      );
  }

}
