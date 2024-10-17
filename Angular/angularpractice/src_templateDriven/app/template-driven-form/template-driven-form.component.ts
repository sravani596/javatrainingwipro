import { Component } from '@angular/core';
import { userdetails } from './userdetails';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent {
  
  usr:userdetails= {"email":"","pwd":""};

  getFormData(data:userdetails){

     console.log(data)

  }



}
