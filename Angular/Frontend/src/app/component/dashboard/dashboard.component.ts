import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicle } from 'src/app/model/vehicle';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

    data: string = '';

    constructor(private vehicleService: VehicleService, private router: Router) {}

    find(searchData: any) {
        this.router.navigate(['/search/' + searchData.form.value.vehicleNumber]);
        console.log("Dashboard " + searchData.form.value.vehicleNumber);
    }

}
