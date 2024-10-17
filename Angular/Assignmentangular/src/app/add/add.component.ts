
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicleService } from '../vehicle/vehicle.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html'
})
export class AddComponent {
  vehicleForm: FormGroup;

  constructor(private fb: FormBuilder, private vehicleService: VehicleService) {
    this.vehicleForm = this.fb.group({
      vno: ['', Validators.required],
      vname: ['', Validators.required],
      price: ['', Validators.required],
      purchasedate: ['', Validators.required]
    });
  }

  addVehicle() {
    if (this.vehicleForm.valid) {
      this.vehicleService.addVehicle(this.vehicleForm.value).subscribe(response => {
        alert('Vehicle added successfully!');
        this.vehicleForm.reset();
      });
    }
  }
}
