import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../vehicle/vehicle.service';// Assuming you have a VehicleService for CRUD operations
import { Router } from '@angular/router';
import { Vehicle } from '../vehicle/vehicle'; // Assuming you have a Vehicle interface/model

@Component({
  selector: 'app-viewall',
  templateUrl: './viewall.component.html',
  styleUrls: ['./viewall.component.css']
})
export class ViewallComponent implements OnInit {  //onInitinterface component life cycle method

  vehicles: Vehicle[] = [];  // Assuming you have an array of Vehicle objects

  constructor(private vehicleService: VehicleService, private router: Router) { }

  ngOnInit(): void {
    this.getAllVehicles();  // Fetch all vehicles on component initialization
    console.log(this.vehicles);  // Debug log to check vehicle data
  
  }

  // Method to get all vehicles (use getAllVehicles instead of getVehicles)
  
  getAllVehicles(): void {
    this.vehicleService.getAllVehicles().subscribe((data: Vehicle[]) => {
      this.vehicles = data;
      console.log('Fetched vehicles:', this.vehicles);
    });
  }
  

  // Add the deleteVehicle method to handle deletion
  deleteVehicle(id: number): void {
    // Check if vno is not empty
    if (!id) {
      console.error('Vehicle number is empty:', id);
      return ;
    }
  
    if (confirm('Are you sure you want to delete this vehicle?')) {
      this.vehicleService.deleteVehicle(id).subscribe(response => {
        console.log(`Vehicle with Vehicle No ${id} deleted successfully.`);
        this.getAllVehicles();  // Refresh the list after deletion
      }, error => {
        console.error('Error deleting the vehicle', error);
      });
    }
  }

  
}  

