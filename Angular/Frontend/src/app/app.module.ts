import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddvehicleComponent } from './component/addvehicle/addvehicle.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { SearchComponent } from './component/search/search.component';
import { DisplayallComponent } from './component/displayall/displayall.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdatevehicleComponent } from './component/updatevehicle/updatevehicle.component';
@NgModule({
  declarations: [
    AppComponent,
    AddvehicleComponent,
    DashboardComponent,
    SearchComponent,
    DisplayallComponent,
    UpdatevehicleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
