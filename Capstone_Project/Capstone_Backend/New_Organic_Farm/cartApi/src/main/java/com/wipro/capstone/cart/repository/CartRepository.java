package com.wipro.capstone.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	 List<Cart> findByCustomerId(Long customerId);
}
