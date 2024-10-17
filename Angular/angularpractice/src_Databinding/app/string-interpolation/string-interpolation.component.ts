import { Component } from '@angular/core';

@Component({
  selector: 'app-string-interpolation',
  templateUrl: './string-interpolation.component.html',
  styleUrls: ['./string-interpolation.component.css']
})
export class StringInterpolationComponent {

  //string interpolation
  title: string = 'Angular Project';
  description: string = 'This is a demo for string interpolation and property binding.';

  //property in the image component
  imageUrl: string ='assets/angular.png';

  // Property in the component
  buttonLabel: string = 'Click Me!';

   // Property for two-way binding
   userName: string = 'sravani';

    // For product purchase functionality
  message: string = '';

  // Method to handle buy button click
  onBuy() {
    this.message = 'Product purchased successfully!';

  }
}
