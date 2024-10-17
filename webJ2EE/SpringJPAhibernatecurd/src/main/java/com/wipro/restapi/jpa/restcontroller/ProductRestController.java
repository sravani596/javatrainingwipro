package com.wipro.restapi.jpa.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wipro.restapi.jpa.entity.Product;
import com.wipro.restapi.jpa.exceptions.ProductNotFoundException;
import com.wipro.restapi.jpa.service.IProductService;


@RestController
@EnableWebSecurity

@RequestMapping("/api/products")
public class ProductRestController {
	
	@Autowired
	private IProductService service;
	
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider    authProvider() {
		
		
		DaoAuthenticationProvider provider=		new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;
	}
	
	
	
	@PostMapping("/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
		
	}
	 
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ADMIN')")
	public    Product updateProduct(Product product) {
		return service.updateProduct(product);
	}
	   
	@DeleteMapping("/delete/{pid}")
	  public   String deleteProductById(@PathVariable int pid) {
		  
		  return service.deleteProductById(pid);
	  }
	   
		@GetMapping("/getbyid/{pid}")
		@PreAuthorize("hasAuthority('USER')")
	   public  Product getProductById(@PathVariable int pid) throws ProductNotFoundException{
		   Product prd=service.getProductById(pid);
		   
		   if(prd==null) {
				
				throw  new ProductNotFoundException();
				
			}
			
		return prd;	

	}
	   
	    
		@GetMapping("/getall")
	 public    List<Product> getAllProducts(){
		 return service.getAllProducts();
	 }
	 
		@GetMapping("/getdate{date}")
	  public  List<Product> getProductsByPurchaseDate(@PathVariable LocalDate date){
		  return service.getProductsBydate(date);
	  }
		@GetMapping("/get-price-gt/{Price}")
		public List<Product>  getByPriceGT(double Price){
			return service.getByPriceGT(Price);
			
		}

		public List<Product>  getBySortedPrice(double price){
			return service.getBySortedPrice(price);
			
		}
		@DeleteMapping("/deletebypname/{pname}")
		public  ResponseEntity<String> deleteByPname(String Pname){
			return service.deleteByPname(Pname);
			
		}


}
