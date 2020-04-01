package com.example.repair.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.UserDTO;
import com.example.repair.model.Address;
import com.example.repair.model.Category;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.User;
import com.example.repair.repo.ServiceProviderRepo;
import com.example.repair.repo.UserRepo;
@Service
public class RepairService{
	
@Autowired 
UserRepo userRepo;

@Autowired
ServiceProviderRepo serviceProviderRepo;

public String login(User user) {
	System.out.println("login............");
	return "login";
}

public User create(UserDTO userDTO) {
	Address address=new Address();
	address.setCompleteAddress(userDTO.getCompleteAddress());
	address.setCurrentLocation(userDTO.getCurrentLocation());
	address.setPinCode(userDTO.getPinCode());
	
	
	
	User user=new User();
	user.setFirstName(userDTO.getFirstName());
	user.setLastName(userDTO.getLastName());
	user.setEmailId(userDTO.getEmailId());
	user.setPhoneNumber(userDTO.getPhoneNumber());
	user.setRoles(userDTO.getRoles());
	
	List<Address> list=new ArrayList<>();
	list.add(address);
	
	user.setAddress(list);
	
	String password = userDTO.getPassword();
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String encodedPassword = passwordEncoder.encode(password);
	
	user.setPassword(encodedPassword);
		userRepo.save(user);
		return userRepo.save(user);
	}

	public ServiceProvider registerRequest(ServiceProviderDTO serviceProviderDTO) {
		Address address=new Address();
		address.setCompleteAddress(serviceProviderDTO.getCompleteAddress());
		address.setCurrentLocation(serviceProviderDTO.getCurrentLocation());
		address.setPinCode(serviceProviderDTO.getPinCode());
		
		Category category=new Category();
		category.setProductName(serviceProviderDTO.getProductName());
		category.setProductType(serviceProviderDTO.getProductType());
		
		ServiceProvider serviceProvider=new ServiceProvider();
		serviceProvider.setServiceProviderName(serviceProviderDTO.getServiceProviderName());
		serviceProvider.setEmailId(serviceProviderDTO.getEmailId());
		serviceProvider.setStatus(false);
		
		
		
		List<Address> list=new ArrayList<>();
		list.add(address);
		
		List<Category> list1=new ArrayList<>();
		list1.add(category);
				
		serviceProvider.setAddress(list);
		serviceProvider.setCategory(list1);
		
		return serviceProviderRepo.save(serviceProvider);
	}

}
