import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { StringInterpolationComponent } from './string-interpolation/string-interpolation.component';

import { FormsModule } from '@angular/forms';
import { ConditionalstmtComponent } from './conditionalstmt/conditionalstmt.component';

@NgModule({
  declarations: [
    AppComponent,
    StringInterpolationComponent,
    ConditionalstmtComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
