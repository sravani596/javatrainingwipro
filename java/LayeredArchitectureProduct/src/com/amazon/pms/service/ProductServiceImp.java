package com.amazon.pms.service;

import com.amazon.pms.dao.IProductDAO;
import com.amazon.pms.dao.ProductDAOImp;
import com.amazon.pms.pojo.Product;
import java.time.LocalDate;
import java.util.List;

public class ProductServiceImp implements IProductService {

    private IProductDAO dao;
    public ProductServiceImp() {
		
		dao = new ProductDAOImp();
	}


    @Override
    public int addProduct(Product prd) {
        return dao.addProduct(prd);
    }

    @Override
    public int updateProduct(Product prd) {
        return dao.updateProduct(prd);
    }

    @Override
    public int deleteProductById(int pid) {
        return dao.deleteProductById(pid);
    }

    @Override
    public Product getProductById(int pid) {
        return dao.getProductById(pid);
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    @Override
    public List<Product> getProductsByPurchaseDate(LocalDate date) {
        return dao.getProductsByPurchaseDate(date);
    }
}

