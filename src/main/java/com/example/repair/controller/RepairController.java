package com.example.repair.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repair.dto.ChangePasswordDTO;
import com.example.repair.dto.OrderDTO;
import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.ServiceRequestDTO;
import com.example.repair.dto.TechnicianAddingDto;
import com.example.repair.dto.UserDTO;
import com.example.repair.dto.VisitDTO;
import com.example.repair.model.CustomerInvoice;
import com.example.repair.model.Order;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.ServiceRequest;
import com.example.repair.model.User;
import com.example.repair.model.Visit;
import com.example.repair.service.RepairService;
import com.example.repair.service.StripeClientService;
import com.stripe.model.Charge;

@RestController
@CrossOrigin
public class RepairController {

	@Autowired
	RepairService repairService;
	
	@Autowired
	StripeClientService stripeClient;
	

	@PostMapping("/signIn")
	public Optional<User> home(@RequestBody User user) {

		return repairService.login(user);
	}
	@PostMapping("/adminLogin")
	public String adminLogin(@RequestBody User user) {
		System.out.println("bhushan");
		return repairService.admin();
		
	}
	@PostMapping("/serviceProviderLogin")
	public Optional<ServiceProvider> login(@RequestBody ServiceProvider serviceProvider){
		System.out.println("service");
		return repairService.serviceProviderLogin(serviceProvider);
	}

	@PostMapping("/signUp")
	public User create(@RequestBody UserDTO userDTO) {
		System.out.println(userDTO.getEmailId());

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
		System.out.println(serviceRequestDTO.getLocalDate());
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
	@PostMapping("/sendPassword")
	public String sendMail(@RequestBody ServiceProviderDTO serviceProviderDTO) {
	        return repairService.sendPassword(serviceProviderDTO);
		
	}
	@GetMapping("/varify")
	public List<ServiceProvider> varifyServiceProvider(){
		return repairService.varifyServiceProviderDetails();
	}
	@GetMapping("/review")
	public List review(String userId) {
		return repairService.getReviewOfServiceRequest(userId);
	}
	@GetMapping("/countType")
	public List countRequestType() {
		return repairService.countType();
	}
	@GetMapping("/countTypeOfAUser")
	public List countRequestTypeOfUser(String userId) {
		return repairService.countTypeOfRequestForUser(userId);
	}
	@PostMapping("/displayProfile")
	public ServiceProvider displayProfile(@RequestBody int spId) {
		return repairService.getSpProfile(spId);
	}

	@PostMapping("/saveTechnician")
	public void saveTechnicianData(@RequestBody TechnicianAddingDto technicianDtoObj) {
		repairService.saveTechieData(technicianDtoObj);

	}

	@PostMapping("/displayTechnician")
	public ServiceProvider displayTechnician(@RequestBody int id) {
		return repairService.getTechnicianData(id);
	}

	@GetMapping("/getInvoice")
	public List getInvoice(String serviceRequestId) {
		return repairService.getInvoice(serviceRequestId);
	}
	
	@PostMapping("/charge")
    public Charge chargeCard(@RequestBody int grandTotal, HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        int amount = grandTotal;
        System.out.println("Token"+ token + "Amount:"+ amount);
        return this.stripeClient.chargeCreditCard(token, amount);
    }
	
	@GetMapping("/getPaymentStatus")
	public List<ServiceRequest> getPaymentStatus(String userId){
		return repairService.getPaymentStatus(userId);
	}
	
	@PostMapping("/changePassword")
	public String change(@RequestBody ChangePasswordDTO changePasswordDTO) throws NotFound {
		System.out.println(changePasswordDTO.getEmailId());
		return repairService.changePassword(changePasswordDTO);
	}
	@GetMapping("/allServiceProvder")
	public List<ServiceProvider> getAllServiceProvider(){
		return repairService.getAllServiceProviderDetails();
	}
	@GetMapping("/allCustomer")
	public List<User> getAllCustomer(){
		return repairService.getAllUserDetails();
	}
	@GetMapping("/allServiceRequest")
	public List<ServiceRequest> getAllServiceRequest(){
		return repairService.getAllServiceRequestDetails();
	}
	

}
