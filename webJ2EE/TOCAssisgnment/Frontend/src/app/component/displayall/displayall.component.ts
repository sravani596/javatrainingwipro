import { Component, OnInit } from '@angular/core';
import { Vehicle } from 'src/app/model/vehicle';
import { VehicleService } from 'src/app/service/vehicle.service';
@Component({
  selector: 'app-displayall',
  templateUrl: './displayall.component.html',
  styleUrls: ['./displayall.component.css']
})
export class DisplayallComponent implements OnInit {

    vehicleList: Vehicle[] = [];

    constructor(private vehicleService: VehicleService) {}

    ngOnInit() {
        this.getAllVehicles();
    }

    getAllVehicles() {
        this.vehicleService.getAll().subscribe(
            (list) => { 
                this.vehicleList = list;  
                console.log(list); 
            }
        );
    }

    deleteById(vehicleId: number) {
        this.vehicleService.delete(vehicleId).subscribe(
            (msg) => { 
                console.log("Deleted " + msg); 
                alert('deleted successfully');
                this.getAllVehicles(); // Refresh list after deletion
            }
        );
    }
}
