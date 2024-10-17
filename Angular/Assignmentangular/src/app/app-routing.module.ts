
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './add/add.component';
import { UpdateComponent } from './update/update.component';
import { SearchComponent } from './search/search.component';
import { ViewallComponent } from './viewall/viewall.component';
const routes: Routes = [
  { path: 'add', component: AddComponent },
  { path: 'update', component: UpdateComponent },
  { path: 'view-all', component: ViewallComponent },
  { path: 'search', component: SearchComponent },
  { path: '', redirectTo: '/view-all', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
