import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin/admin.service';

@Component({
  selector: 'app-ad-login',
  templateUrl: './ad-login.component.html',
  styleUrls: ['./ad-login.component.css']
})
export class AdLoginComponent {

  // email: string = '';
  // password: string = '';

  // constructor(private router: Router) {}

  // onLoginSubmit() {
  //   // Here, you would call a service to authenticate the user using the email and password
  //   console.log('Logging in with email:', this.email, 'and password:', this.password);
  // }

  email: string = '';
  password: string = '';
  errorMessage: string = ''; // Property to hold error messages

  constructor(private router: Router, private adminService: AdminService) {} // Inject AdminService

  onLoginSubmit() {
    // Clear any previous error message
    this.errorMessage = '';

    // Call the login method from AdminService
    this.adminService.login(this.email, this.password).subscribe({
      next: (response) => {
        if (response) { // Check if the response is valid
          console.log('Login successful:', response);
          this.router.navigate(['/admin/dashboard']); // Redirect to dashboard on successful login
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
}
