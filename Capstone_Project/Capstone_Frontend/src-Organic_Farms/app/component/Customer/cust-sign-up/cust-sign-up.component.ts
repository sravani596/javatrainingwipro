import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { NgForm } from '@angular/forms';
import { CustomerService } from 'src/app/service/customer/customer.service';

@Component({
  selector: 'app-cust-sign-up',
  templateUrl: './cust-sign-up.component.html',
  styleUrls: ['./cust-sign-up.component.css']
})
export class CustSignUpComponent {
  @ViewChild('signupForm') signupForm!: NgForm; // Access the form
  customer: Customer = new Customer(); // Create instance of Customer model
  errorMessage: string = ''; // To store error message

  constructor(private customerService: CustomerService, private router: Router) {}

  // Function to submit the sign-up form
  onSignupSubmit() {
    if (this.signupForm.valid) {
      // Populate customer from the form
      this.customer = this.signupForm.value;

      // Call the service method to insert the customer
      this.customerService.insertCustomer(this.customer).subscribe({
        next: (response) => {
          console.log('Customer created:', response);
          this.router.navigate(['/customer/login']); // Navigate after successful sign-up
        },
        error: (error) => {
          console.error('Error during sign-up:', error);
          this.errorMessage = 'Failed to sign up. Please try again later.';
        }
      });
    } else {
      console.log('Form is not valid');
    }
  }

  // Function to clear all form fields
  onClear() {
    this.signupForm.resetForm();
  }
}
