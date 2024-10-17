import { Component } from '@angular/core';

import { Vehicle } from '../vehicle/vehicle';
import { VehicleService } from '../vehicle/vehicle.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  vehicle: Vehicle | null = null;
  searchKey: string = '';

  constructor(private vehicleService: VehicleService) { }

  searchVehicle() {
    this.vehicleService.getVehicleByNumber(this.searchKey).subscribe((data: Vehicle[]) => {
      if (data.length > 0) {
        this.vehicle = data[0];  // Assuming the first match is the desired vehicle
      } else {
        this.vehicle = null;  // No match found
      }
    });
  }
}
