import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Vehicle } from 'src/app/model/vehicle';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  vehicle: Vehicle = new Vehicle();
  searchInput: string = '';

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) {}

  ngOnInit(): void {
    this.find();
  }

  find() {
    this.route.params.subscribe(param => { 
      this.searchInput = param['input']; 
      console.log("input param " + this.searchInput);

      this.vehicleService.find(this.searchInput).subscribe(input => {
        this.vehicle = input;
        console.log('Vehicle ' + input);
      });
    });
  }
}
