package com.example.repair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repair.model.User;
import com.example.repair.service.RepairService;

@RestController
public class RepairController {
	
	@Autowired
	RepairService repairService;

	@PostMapping("/signIn")
	public String home(@RequestBody User user) {
		
		return repairService.login(user);
	}
	
	@PostMapping("/signUp")
	public User create(@RequestBody User user) {
		System.out.println("create account");
		return repairService.create(user);
	}
	

}
