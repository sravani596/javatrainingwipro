package com.amazon.pms.service.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.amazon.pms.pojo.Product;
import com.amazon.pms.service.IProductService;
import com.amazon.pms.service.ProductServiceImp;


class ProductServiceImpTest {

	
	static  IProductService service;
	 
	 @BeforeAll
	 public static void beforeAll() {
		 
		 service = new ProductServiceImp();
		 
	 }
	
	@Test
	void testAddProduct() {
		//fail("Not yet implemented");
		 LocalDate purchaseDate = LocalDate.parse("2020-05-03");
		Product prd = new Product(8,"car",20000,purchaseDate);
		int count = service.addProduct(prd);
		assertEquals(1, count);
		
		//	assertTrue(count > 0);
			
		//	assertNotEquals(0, count);
	
	}

	@Test
	void testUpdateProduct() {
		
			}

	@Test
	void testDeleteProductById() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetProductById() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetAllProducts() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetProductsByPurchaseDate() {
		//fail("Not yet implemented");
	}

}
