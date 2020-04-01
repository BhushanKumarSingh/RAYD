package com.example.repair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.UserDTO;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.User;
import com.example.repair.service.RepairService;

@RestController
@CrossOrigin
public class RepairController {
	
	@Autowired
	RepairService repairService;

	@PostMapping("/signIn")
	public String home(@RequestBody User user) {
		
		return repairService.login(user);
	}
	
	@PostMapping("/signUp")
	public User create(@RequestBody UserDTO userDTO) {
	
		return repairService.create(userDTO);
	}
	
	@PostMapping("/serviceProviderRequest")
	public ServiceProvider request(@RequestBody ServiceProviderDTO serviceProviderDTO) {
		return repairService.registerRequest(serviceProviderDTO);
		
	}
	

}
