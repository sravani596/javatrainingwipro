package com.wipro.restapi.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.restapi.jpa.entity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

		
			public UserEntity  findByUserName(String username);
		
	
	
}
