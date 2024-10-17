import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FarmPartnerService } from 'src/app/service/farmPartner/farm-partner.service';



@Component({
  selector: 'app-partner-login',
  templateUrl: './partner-login.component.html',
  styleUrls: ['./partner-login.component.css']
})
export class PartnerLoginComponent {

  // constructor(private router: Router) {}

  // navigateToSignUp() {
  //   this.router.navigate(['farmPartner/signup']);
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
  //   this.router.navigate(['farmPartner/signup']);
  // }

  email: string = '';
  password: string = '';

  constructor(private router: Router, private farmPartnerService: FarmPartnerService) {}

  onLoginSubmit() {
    // Call the login method in the service to authenticate
    this.farmPartnerService.login(this.email, this.password).subscribe(response => {
      if (response) {
        // If login is successful, navigate to a new page or dashboard
        console.log('Login successful', response);
        this.router.navigate(['farmPartner/dashboard']);
      } else {
        // Handle incorrect login credentials
        console.log('Invalid credentials');
        alert('Invalid email or password');
      }
    }, error => {
      console.error('Error during login', error);
      alert('An error occurred during login');
    });
  }

  navigateToSignup() {
    // Redirect to the Sign Up page
    this.router.navigate(['farmPartner/signup']);
  }
}
