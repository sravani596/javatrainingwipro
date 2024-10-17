package com.wipro.restapi.jpa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import com.wipro.restapi.jpa.entity.Product;

public interface IProductService {

	public Product addProduct(Product prd);
	 
	public    Product updateProduct(Product prd);
	    
	  public   String deleteProductById(int pid);
	    
	   public  Product getProductById(int pid);
	    
	 public    List<Product> getAllProducts();
	 
	 public Product  getByPname(String pname);
	    
	  public  List<Product> getProductsBydate(LocalDate date);
	  	
	  public List<Product>  getByPriceGT(double Price);

		public List<Product>  getBySortedPrice(double price);
		
		public  ResponseEntity<String> deleteByPname(String Pname);
		

}
