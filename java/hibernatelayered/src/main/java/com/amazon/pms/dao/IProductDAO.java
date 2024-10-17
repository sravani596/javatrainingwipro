package com.amazon.pms.dao;

import java.time.LocalDate;
import java.util.List;

import com.amazon.pms.pojo.Product;


public interface IProductDAO {

	    int addProduct(Product prd);
	 
	    int updateProduct(Product prd);
	 
	    int deleteProductById(int pid);
	    
	    Product getProductById(int pid); 
											
	 
	    List<Product> getAllProducts();

	    List<Product> getProductsByPurchaseDate(LocalDate date);
	}
	   
