import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer/customer.service';

@Component({
  selector: 'app-cust-login',
  templateUrl: './cust-login.component.html',
  styleUrls: ['./cust-login.component.css']
})
export class CustLoginComponent {

  // constructor(private router: Router) {}

  // navigateToSignUp() {
  //   this.router.navigate(['customer/signup']);
  // }

  // navigateToAdmin() {
  //   this.router.navigate(['/admin/login']);
  // }

  // navigateToFarmPartner() {
  //   this.router.navigate(['farmPartner/login'])
  // }

  // email: string = '';
  // password: string = '';

  // constructor(private router: Router) {}

  // onLoginSubmit() {
  //   // Here, you would call a service to authenticate the user using the email and password
  //   console.log('Logging in with email:', this.email, 'and password:', this.password);
  // }

  // navigateToSignup() {
  //   // Redirect to the Sign Up page
  //   this.router.navigate(['customer/signup']);
  // }

  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private router: Router, private customerService: CustomerService) {}

  onLoginSubmit() {
    // Clear any previous error message
    this.errorMessage = '';

    this.customerService.login(this.email, this.password).subscribe({
      next: (response) => {
        if (response) { // Check if the response is valid
          console.log('Login successful:', response);
          this.router.navigate(['/customer/dashboard']); // Redirect to dashboard on successful login
        } else {
          this.errorMessage = 'Login failed. Please check your credentials.'; // Set error message
        }
      },
      error: (error) => {
        console.error('Error during login', error);
        this.errorMessage = 'Login failed. Please check your credentials.'; // Set error message
      }
    });
  }

  navigateToSignup() {
    this.router.navigate(['customer/signup']);
  }

  navigateToAdmin() {
    this.router.navigate(['/admin/login']);
  }

  navigateToFarmPartner() {
    this.router.navigate(['farmPartner/login']);
  }
}
