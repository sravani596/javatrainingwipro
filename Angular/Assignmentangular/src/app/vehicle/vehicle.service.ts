
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicle } from './vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService { //component -->service //service --->connect with db.json
  private baseUrl = 'http://localhost:3000/vehicle';

  constructor(private http: HttpClient) {}

  getVehicleByNumber(vno: string): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${this.baseUrl}?vno=${vno}`);
  }
  
  getAllVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(this.baseUrl);
  }
  

  getVehicleById(vno: number): Observable<Vehicle> {
    return this.http.get<Vehicle>(`${this.baseUrl}/${vno}`);
  }

  addVehicle(vehicle: Vehicle): Observable<Vehicle> {
    return this.http.post<Vehicle>(this.baseUrl, vehicle);
  }

  updateVehicle(id: number, vehicle: Vehicle): Observable<Vehicle> {
    return this.http.put<Vehicle>(`${this.baseUrl}/${id}`, vehicle);
  }
  

  deleteVehicle(id: number): Observable<any> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
