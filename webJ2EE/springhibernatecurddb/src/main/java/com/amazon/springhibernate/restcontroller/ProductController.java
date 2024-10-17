package com.amazon.springhibernate.restcontroller;


	import java.time.LocalDate;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

import com.amazon.pms.pojo.Product;
import com.amazon.pms.service.IProductService;

	@RestController
	@RequestMapping("/api/products")
	public class ProductController {

	    @Autowired
	    private IProductService productService;

	    @GetMapping("/get/{pid}")
	    public Product getById(@PathVariable int pid) {
	        return productService.getProductById(pid);
	    }

	    @DeleteMapping("/delete/{pid}")
	    public String deleteById(@PathVariable int pid) {
	        productService.deleteProduct(pid);
	        return pid + " record deleted";
	    }

	    @PostMapping("/add")
	    public Product addProduct(@RequestBody Product product) {
	        productService.addProduct(product);
	        return product;
	    }

	    @PutMapping("/update")
	    public Product updateProduct(@RequestBody Product product) {
	        productService.updateProduct(product);
	        return product;
	    }

	    @GetMapping("/getall")
	    public List<Product> getAll() {
	        return productService.getAllProducts();
	    }
	}



