import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddvehicleComponent } from './component/addvehicle/addvehicle.component';
import { DisplayallComponent } from './component/displayall/displayall.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { SearchComponent } from './component/search/search.component';
import { UpdatevehicleComponent } from './component/updatevehicle/updatevehicle.component';

const routes: Routes = [
    { path: 'home', component: DashboardComponent },
    { path: 'addvehicle', component: AddvehicleComponent },
    { path: 'displayall', component: DisplayallComponent },
    { path: 'search/:input', component: SearchComponent },
    {path:'updatevehicle',component:UpdatevehicleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
