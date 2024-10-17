import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from '../model/vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  // Base URL for the vehicle API
  baseURL: string = 'http://localhost:9090/api/vehicles';

  // Get all vehicles
  getAll(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${this.baseURL}/getall`);
  }

  // Insert a new vehicle
  insert(body: Vehicle): Observable<Vehicle> {
    console.log(body);
    return this.http.post<Vehicle>(`${this.baseURL}/add`, body);
  }
//update
  update(body:Vehicle):Observable<Vehicle>{

    console.log(body);

      return this.http.put<Vehicle>(this.baseURL+"/update",body);

  }

  // Delete a vehicle by ID
delete(vehicleId: number): Observable<string> {
  return this.http.delete<string>(`${this.baseURL}/deletebyid/${vehicleId}`);
}


  // Find a vehicle by ID
  find(vehicleNumber: string): Observable<Vehicle> {
    console.log("service " + vehicleNumber);
    return this.http.get<Vehicle>(`${this.baseURL}/getvehicle/${vehicleNumber}`);
  }

  // Find a vehicle by vehicleName
  findByVehicleName(vehicleName: string): Observable<Vehicle> {
    console.log("Service: Fetching vehicle with name: " + vehicleName);
    return this.http.get<Vehicle>(`${this.baseURL}/getbyname/${vehicleName}`);
  }

}
