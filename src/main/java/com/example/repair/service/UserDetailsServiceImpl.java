package com.example.repair.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.repair.model.MyUserDetails;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.User;
import com.example.repair.repo.ServiceProviderRepo;
import com.example.repair.repo.UserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	ServiceProviderRepo serviceProviderRepo;

	@Override
	public UserDetails loadUserByUsername(String emailId) {
		System.out.println(emailId);
		Optional<User> user=userRepo.findByEmailId(emailId);
		System.out.println(user.isPresent());
		if(user.isPresent()) {
			
			return user.map(MyUserDetails::new).get();
		}
		else {
			System.out.println("bhushan");
			Optional<ServiceProvider> serviceProvider=serviceProviderRepo.findByEmailId(emailId);
			System.out.println(serviceProvider.isPresent());
			return serviceProvider.map(MyUserDetails::new).get();	
		}
		
//		user.orElseThrow(()->new UsernameNotFoundException("Not found user "+emailId));
		
		}

}
