package com.amazon.pms.service;

import java.time.LocalDate;
import java.util.List;
import com.amazon.pms.pojo.Product;


	public interface IProductService {

		public int addProduct(Product product);
		 
		public    int updateProduct(Product product);
		    
		  public   int deleteProductById(int pid);
		    
		   public  Product getProductById(int pid);
		    
		 public    List<Product> getAllProducts();
		    
		  public  List<Product> getProductsByPurchaseDate(LocalDate date);

}

