import { Component } from '@angular/core';
import { Product } from 'src/app/model/Product';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent {

  product: Product = new Product();
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private productService: ProductService) {}

  onSubmit() {
    this.productService.insertCustomer(this.product).subscribe(
      response => {
        this.successMessage = 'Product added successfully!';
        this.errorMessage = '';
        this.clearForm(); // Clear the form after submission
      },
      error => {
        this.errorMessage = 'Error adding product. Please try again.';
        this.successMessage = '';
      }
    );
  }

  clearForm() {
    this.product = new Product(); // Reset product object
    this.successMessage = '';
    this.errorMessage = '';
  }
}
