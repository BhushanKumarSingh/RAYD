package com.example.repair.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repair.dto.OrderDTO;
import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.ServiceRequestDTO;
import com.example.repair.dto.UserDTO;
import com.example.repair.dto.VisitDTO;
import com.example.repair.model.Order;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.ServiceRequest;
import com.example.repair.model.User;
import com.example.repair.model.Visit;
import com.example.repair.service.RepairService;

@RestController
@CrossOrigin
public class RepairController {

	@Autowired
	RepairService repairService;

	@PostMapping("/signIn")
	public Optional<User> home(@RequestBody User user) {

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

	@PostMapping("/addProblem")
	public String addProblem(@RequestBody ServiceRequestDTO serviceRequestDTO) {
		return repairService.addServiceRequest(serviceRequestDTO);
	}

	@GetMapping("/getAddress")
	public List getAddress(String userId) {

		return repairService.findAddress(userId);
	}

	@GetMapping("/getProblem")
	public List<ServiceRequest> getProblem(String userId) {
		return repairService.getServiceRequest(userId);
	}

	@GetMapping("/getServices")
	public List getServices(String serviceProviderId) {
		return repairService.serviceProvided(serviceProviderId);
	}

	@GetMapping("/openRequest")
	public List getOpenRequest() {
		return repairService.openRequest();
	}
	@PostMapping("/assignServiceProvider")
	public ServiceRequest update(@RequestBody ServiceRequestDTO serviceRequestDTO) {
		return repairService.update(serviceRequestDTO);
	}
	
	@PostMapping("/orderDetails")
	public Order orderDetails(@RequestBody OrderDTO orderDTO) {
		return repairService.parts(orderDTO);
		
	}
	
	@PostMapping("/visitingDetails")
	public Visit visitingDetails(@RequestBody VisitDTO visitDTO) {
		return repairService.visiting(visitDTO);
	}

}
