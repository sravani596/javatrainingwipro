package com.wipro.restapi.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.restapi.jpa.entity.UserEntity;
import com.wipro.restapi.jpa.repository.UserRepository;



@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
			@Autowired
			UserRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				UserEntity user =			repo.findByUserName(username);
		
					if(user == null)
					{
						
						throw new UsernameNotFoundException(username);
						
					}
					
				
					return  new UserDetailsImp(user);
		
	}

}
