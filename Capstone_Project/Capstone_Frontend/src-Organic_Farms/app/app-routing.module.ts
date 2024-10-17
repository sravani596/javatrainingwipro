import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdLoginComponent } from './component/Admin/ad-login/ad-login.component';
import { CustLoginComponent } from './component/Customer/cust-login/cust-login.component';
import { PartnerLoginComponent } from './component/FarmPartner/partner-login/partner-login.component';
import { PartnerDashboardComponent } from './component/FarmPartner/partner-dashboard/partner-dashboard.component';
import { UpdateFarmPartnerComponent } from './component/FarmPartner/update-farm-partner/update-farm-partner.component';
import { CreateProductComponent } from './component/FarmPartner/create-product/create-product.component';
import { DeleteProductComponent } from './component/FarmPartner/delete-product/delete-product.component';
import { GetAllProductComponent } from './component/FarmPartner/get-all-product/get-all-product.component';
import { GetProductIdComponent } from './component/FarmPartner/get-product-id/get-product-id.component';
import { UpdateProductComponent } from './component/FarmPartner/update-product/update-product.component';

const routes: Routes = [
  { path: '', redirectTo: 'customer/login', pathMatch: 'full' },
  { path: 'customer/login', component: CustLoginComponent },
  { path: 'farmPartner/login', component: PartnerLoginComponent },
  { 
    path: 'farmPartner/dashboard', 
    component: PartnerDashboardComponent, 
    children: [
      { path: 'update', component: UpdateFarmPartnerComponent },
      { 
        path: 'product', 
        children: [
          { path: 'add', component: CreateProductComponent },
          { path: 'update', component: UpdateProductComponent },  // Update path for product
          { path: 'getById', component: GetProductIdComponent },
          { path: 'getAll', component: GetAllProductComponent },
          { path: 'delete', component: DeleteProductComponent }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
