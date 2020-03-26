package com.example.repair.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.repair.model.MyUserDetails;
import com.example.repair.model.User;
import com.example.repair.repo.UserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String emailId) {
	System.out.println(emailId);
		Optional<User> user=userRepo.findByEmailId(emailId);
		System.out.println(user.get().getPassword());
		
//		user.orElseThrow(()->new UsernameNotFoundException("Not found user "+emailId));
		return user.map(MyUserDetails::new).get();	
		}

}
