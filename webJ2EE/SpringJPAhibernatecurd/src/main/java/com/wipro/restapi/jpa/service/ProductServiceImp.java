package com.wipro.restapi.jpa.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.restapi.jpa.entity.Product;
import com.wipro.restapi.jpa.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	private ProductRepository repo;
	
	
	
	
	
	

	@Override
	public Product addProduct(Product prd) {
		
		return  repo.save(prd);
	}

	@Override
	public Product updateProduct(Product prd) {
		
		return repo.save(prd); //save methods are inside the jpa repository save is 2in1 method
	}

	@Override
	public String deleteProductById(int pid) {
		
		repo.deleteById(pid);
		
		return  "Record deleted with pid"+pid;
	}

	@Override
	public Product getProductById(int pid) { //IProductService defining method implementation
		
		return repo.findById(pid).orElse(null); //repository methods findBy remaining CamelCase
	}

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}
	
	@Override
	public Product getByPname(String pname) {
		
		return repo.findByPname(pname);
	}


	@Override
	public List<Product> getProductsBydate(LocalDate date) {
		
		return repo.findByDate(date) ;
		
	}

	@Override
	public List<Product> getByPriceGT(double Price) {
		return repo.findByPriceGreaterThan(Price);
		
	}

	@Override
	public List<Product> getBySortedPrice(double Price) {
		
		return repo.findAll(Sort.by("Price").descending());
		
	}

	@Override
	public ResponseEntity<String> deleteByPname(String Pname) {
		
			repo.deleteByPname(Pname);
		
		return new ResponseEntity<String>("Record deleted..",HttpStatus.ACCEPTED);
	}

	
}
