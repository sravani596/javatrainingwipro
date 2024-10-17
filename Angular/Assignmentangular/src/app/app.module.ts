import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {FormsModule, ReactiveFormsModule}  from '@angular/forms';
import { AddComponent } from './add/add.component';
import { UpdateComponent } from './update/update.component';

import { SearchComponent } from './search/search.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { ViewallComponent } from './viewall/viewall.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({ //decorator
  declarations: [       // components
    AppComponent, AddComponent, UpdateComponent,  SearchComponent, VehicleComponent, ViewallComponent
  ],
  imports: [          // modules
    BrowserModule,
    AppRoutingModule,
    FormsModule, //ngmodel two-way databinding
    ReactiveFormsModule, //reactive form module
    HttpClientModule //get post delete

  ],
  providers: [],   // service classes
  bootstrap: [AppComponent]
})
export class AppModule { }
