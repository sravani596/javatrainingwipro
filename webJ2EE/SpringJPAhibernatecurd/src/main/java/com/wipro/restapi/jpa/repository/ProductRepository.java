package com.wipro.restapi.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.restapi.jpa.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public Product findByPname(String Pname);
	public List<Product> findByDate(LocalDate date);
	
	
	public List<Product>  findByPriceGreaterThan(double Product);
	
	@Query("select p  from Product p where p.price >?1 order by p.price")
	public List<Product>  findAllSorted(double price);
	
	
	
	@Modifying // only for DML Queries in service we have to add transactional annotation
	@Query("delete from Product p where p.pname =?1")
	public void   deleteByPname(String pname);


}
