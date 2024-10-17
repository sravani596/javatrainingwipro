package com.wipro.capstone.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
