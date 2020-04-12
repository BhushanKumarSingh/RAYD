package com.example.repair.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.ServiceRequestDTO;
import com.example.repair.dto.UserDTO;
import com.example.repair.model.Address;
import com.example.repair.model.Category;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.ServiceRequest;
import com.example.repair.model.Status;
import com.example.repair.model.User;
import com.example.repair.repo.ServiceProviderRepo;
import com.example.repair.repo.ServiceRequestRepo;
import com.example.repair.repo.UserRepo;
@Service
public class RepairService{
	
@Autowired 
UserRepo userRepo;

@Autowired
ServiceProviderRepo serviceProviderRepo;

@Autowired
ServiceRequestRepo serviceRequestRepo;


public Optional<User> login(User user) {
	System.out.println("login............");
	return userRepo.findByEmailId(user.getEmailId());
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
	public String addServiceRequest( ServiceRequestDTO serviceRequestDTO){
		
		Optional<User> user=userRepo.findById(serviceRequestDTO.getUserId());
		User us=new User();
		us.setUserId(user.get().getUserId());
		us.setEmailId(user.get().getEmailId());
		us.setFirstName(user.get().getFirstName());
		us.setLastName(user.get().getLastName());
		us.setPassword(user.get().getPassword());
		us.setPhoneNumber(user.get().getPhoneNumber());
		us.setRoles(user.get().getRoles());
		
		List<Address> list1=user.get().getAddress();
		Address address=new Address();
		address.setCompleteAddress(serviceRequestDTO.getCompleteAddress());
		address.setCurrentLocation(serviceRequestDTO.getCurrentLocation());
		address.setPinCode(serviceRequestDTO.getPinCode());
		
		
		List<Address> list=new ArrayList<>();
		
		list1.forEach((data)->list.add(data));
		
		list.add(address);
		
		
		us.setAddress(list);
		if(serviceRequestDTO.getAddressId()==0)
		userRepo.save(us);
		
		ServiceRequest serviceRequest=new ServiceRequest();
		serviceRequest.setCompanyName(serviceRequestDTO.getCompanyName());
		serviceRequest.setDescription(serviceRequestDTO.getDescription());
		serviceRequest.setModelNumber(serviceRequestDTO.getModelNumber());
		serviceRequest.setProductName(serviceRequestDTO.getProductName());
		serviceRequest.setProductType(serviceRequestDTO.getProductType());
		serviceRequest.setUserId(serviceRequestDTO.getUserId());
		serviceRequest.setStatus(Status.VISITED);
		
		serviceRequestRepo.save(serviceRequest);
		
		return "add";
		
	}
	public List findAddress(String userId) {

		Optional<User> user=userRepo.findById(Integer.parseInt(userId));
//		System.out.println(user.get().getAddress().get(0).getCurrentLocation());
		return user.get().getAddress();
	}
	public List<ServiceRequest> getServiceRequest(String userId) {
		int id=Integer.parseInt(userId);
		return serviceRequestRepo.findByUserId(id);
	}

}
