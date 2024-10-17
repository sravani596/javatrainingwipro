package com.wipro.restapi.jpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.wipro.restapi.jpa.entity.Product;

@SpringBootTest
class ProductServiceImpTest {
	
	@Autowired
	IProductService service;
	
	@Autowired 
	Product prd;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testAddProduct() {
		// Setting product details
		prd.setPid(105);
		prd.setPname("laptop");
		prd.setPrice(50000);
		prd.setSPmail_id("srsatp@gmail.com");
		prd.setdate(LocalDate.of(2024, 9, 18));
		
		// Adding the product
		Product p1 = service.addProduct(prd);
		
		// Assertions to validate the result
		assertEquals(105, p1.getPid());
		assertNotNull(p1);
	}
	
	@Test
	void testGetProductById() {
		// Retrieving a product by ID
		Product product = service.getProductById(105);
		
		// Checking if product name matches
		assertEquals("laptop", product.getPname());
	}
	
	@Test
	void testGetAllProducts() {
		// Fetching all products
		List<Product> productList = service.getAllProducts();
		
		// Verifying the list is not empty
		assertTrue(productList.size() > 0);
	}

	@Test
	void testGetByPname() {
		// Fetch product by id
		Product p1 = service.getProductById(103);
		
		// Ensuring the product is not null
		assertNotNull(p1);
	}

	@Test
	void testDeleteByPname() {
		// Deleting a product by name
		ResponseEntity<String> response = service.deleteByPname("mobile");
		
		// Verifying the status code
		assertEquals(202, response.getStatusCodeValue());
	}
}
