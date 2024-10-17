export class Vehicle {
    vehicleId: number = 0;
    vehicleNumber: string = ''; // Allows for alphanumeric input like 'ABC123'
    vehicleName: string = '';
    price: number = 0.0;
    purchaseDate: Date = new Date();
}
