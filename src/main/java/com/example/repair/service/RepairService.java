package com.example.repair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repair.model.User;
import com.example.repair.repo.UserRepo;
@Service
public class RepairService{
	
@Autowired 
UserRepo userRepo;

public String login(User user) {
	return "login";
}

public User create(User user) {
	String password = user.getPassword();
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String encodedPassword = passwordEncoder.encode(password);
	
	user.setPassword(encodedPassword);
		userRepo.save(user);
		return userRepo.save(user);
	}

}
