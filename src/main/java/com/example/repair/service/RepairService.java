package com.example.repair.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repair.dto.ChangePasswordDTO;
import com.example.repair.dto.OrderDTO;
import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.ServiceRequestDTO;
import com.example.repair.dto.TechnicianAddingDto;
import com.example.repair.dto.UserDTO;
import com.example.repair.dto.VisitDTO;
import com.example.repair.model.Address;
import com.example.repair.model.Category;
import com.example.repair.model.CustomerInvoice;
import com.example.repair.model.Order;
import com.example.repair.model.Parts;
import com.example.repair.model.Payment;
import com.example.repair.model.PaymentStatus;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.ServiceRequest;
import com.example.repair.model.Status;
import com.example.repair.model.Technician;
import com.example.repair.model.User;
import com.example.repair.model.Visit;
import com.example.repair.repo.CustomerInvoiceRepo;
import com.example.repair.repo.OrderRepo;
import com.example.repair.repo.ServiceProviderRepo;
import com.example.repair.repo.ServiceRequestRepo;
import com.example.repair.repo.UserRepo;
import com.example.repair.repo.VisitRepo;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class RepairService{
	
@Autowired 
UserRepo userRepo;

@Autowired
ServiceProviderRepo serviceProviderRepo;

@Autowired
ServiceRequestRepo serviceRequestRepo;

@Autowired
OrderRepo orderRepo;

@Autowired
VisitRepo visitRepo;

@Autowired
CustomerInvoiceRepo customerInvoiceRepo;

@Autowired
private JavaMailSender sender;


public Optional<User> login(User user) {
	System.out.println("login............");
	return userRepo.findByEmailId(user.getEmailId());
}
public String admin() {
	return "admin login";
}
public Optional<ServiceProvider> serviceProviderLogin(ServiceProvider serviceProvider){
	return serviceProviderRepo.findByEmailId(serviceProvider.getEmailId());
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
	user.setRoles("ROLE_"+userDTO.getRoles());
	
	List<Address> list=new ArrayList<>();
	list.add(address);
	
	user.setAddress(list);
	
	String password = userDTO.getPassword();
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String encodedPassword = passwordEncoder.encode(password);
	
	user.setPassword(encodedPassword);
		userRepo.save(user);
		System.out.println("bhushan");
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
		serviceProvider.setRoles("ROLE_SERVICEPROVIDER");
		
		
		
		List<Address> list=new ArrayList<>();
		list.add(address);
		
		List<Category> list1=new ArrayList<>();
		list1.add(category);
				
		serviceProvider.setAddress(list);
		serviceProvider.setCategory(list1);
		Optional<ServiceProvider> serviceProvider1=serviceProviderRepo.findByEmailId(serviceProviderDTO.getEmailId());
		if(serviceProvider1.isPresent())
			serviceProvider.setServiceProviderId(serviceProvider1.get().getServiceProviderId());
			
		
		return serviceProviderRepo.save(serviceProvider);
	}
	public String addServiceRequest( ServiceRequestDTO serviceRequestDTO){
		Optional<User> user=userRepo.findByUserId(serviceRequestDTO.getUserId());
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
		if(serviceRequestDTO.getAddressId()==0) {
			User user1= userRepo.save(us);
			
			serviceRequestDTO.setAddressId(user1.getAddress().get(user1.getAddress().size()-1).getAddressId());
			
		}
		
		ServiceRequest serviceRequest=new ServiceRequest();
		serviceRequest.setCompanyName(serviceRequestDTO.getCompanyName());
		serviceRequest.setDescription(serviceRequestDTO.getDescription());
		serviceRequest.setModelNumber(serviceRequestDTO.getModelNumber());
		serviceRequest.setProductName(serviceRequestDTO.getProductName());
		serviceRequest.setProductType(serviceRequestDTO.getProductType());
		serviceRequest.setUserId(serviceRequestDTO.getUserId());
		serviceRequest.setAddressId(serviceRequestDTO.getAddressId());
		serviceRequest.setStatus(Status.OPEN);
		LocalDate localDate = LocalDate.now();
		serviceRequest.setLocalDate(localDate);
		
		serviceRequestRepo.save(serviceRequest);
		
		return "add";
		
	}
	public List findAddress(String userId) {

		Optional<User> user=userRepo.findByUserId(Integer.parseInt(userId));
//		System.out.println(user.get().getAddress().get(0).getCurrentLocation());
		return user.get().getAddress();
	}
	public List<ServiceRequest> getServiceRequest(String userId) {
		int id=Integer.parseInt(userId);
		return serviceRequestRepo.findByUserId(id);
	}
	public List serviceProvided(String serviceProviderId) {
		int id=Integer.parseInt(serviceProviderId);
		return serviceRequestRepo.findByServiceProviderId(id);
	}
	
	public List openRequest() {
		//List list=serviceRequestRepo.findByStatus(Status.OPEN);
		List list=serviceRequestRepo.getOpenRequestWithAddress();
		
		System.out.println(list.size());
		return list;
	}
	public ServiceRequest update(ServiceRequestDTO serviceRequestDTO) {
		ServiceRequest s=new ServiceRequest();
		s.setServiceRequestId(serviceRequestDTO.getServiceRequestId());
		s.setStatus(Status.ACCEPTED);
		s.setCompanyName(serviceRequestDTO.getCompanyName());
		s.setDescription(serviceRequestDTO.getDescription());
		s.setModelNumber(serviceRequestDTO.getModelNumber());
		s.setProductName(serviceRequestDTO.getProductName());
		s.setProductType(serviceRequestDTO.getProductType());
		s.setServiceProviderId(serviceRequestDTO.getServiceProviderId());
		s.setAddressId(serviceRequestDTO.getAddressId());
		s.setUserId(serviceRequestDTO.getUserId());
		s.setLocalDate(serviceRequestDTO.getLocalDate());
		
		Payment payment=new Payment();
		payment.setPaymentStatus(PaymentStatus.NOT_COMPLETED);
		s.setPayment(payment);
		return serviceRequestRepo.save(s);
	}
	
	public Order parts(OrderDTO orderDTO) {
		
		Optional<ServiceRequest> serviceRequestDTO =serviceRequestRepo.findById(orderDTO.getServiceRequestId());
		ServiceRequest s=new ServiceRequest();
		s.setServiceRequestId(serviceRequestDTO.get().getServiceRequestId());
		s.setStatus(Status.COMPLETED);
		s.setCompanyName(serviceRequestDTO.get().getCompanyName());
		s.setDescription(serviceRequestDTO.get().getDescription());
		s.setModelNumber(serviceRequestDTO.get().getModelNumber());
		s.setProductName(serviceRequestDTO.get().getProductName());
		s.setProductType(serviceRequestDTO.get().getProductType());
		s.setServiceProviderId(serviceRequestDTO.get().getServiceProviderId());
		s.setAddressId(serviceRequestDTO.get().getAddressId());
		s.setUserId(serviceRequestDTO.get().getUserId());
		s.setLocalDate(serviceRequestDTO.get().getLocalDate());
		s.setPayment(serviceRequestDTO.get().getPayment());
		serviceRequestRepo.save(s);
		
		Parts parts=new Parts();
		parts.setPartsName(orderDTO.getPartsName());
		parts.setPrice(orderDTO.getPrice());
		parts.setServiceCharge(orderDTO.getServiceCharge());
		parts.setQuantity(orderDTO.getQuantity());
		
		List l=new ArrayList();
		l.add(parts);
		
		Order order=new Order();
		order.setServiceRequestId(orderDTO.getServiceRequestId());
		order.setParts(l);
		
		
		return orderRepo.save(order);
		
	}
	public Visit visiting(VisitDTO visitDTO) {
		Optional<ServiceRequest> serviceRequestDTO =serviceRequestRepo.findById(visitDTO.getServiceRequestId());
		ServiceRequest s=new ServiceRequest();
		s.setServiceRequestId(serviceRequestDTO.get().getServiceRequestId());
		s.setStatus(Status.VISITED);
		s.setCompanyName(serviceRequestDTO.get().getCompanyName());
		s.setDescription(serviceRequestDTO.get().getDescription());
		s.setModelNumber(serviceRequestDTO.get().getModelNumber());
		s.setProductName(serviceRequestDTO.get().getProductName());
		s.setProductType(serviceRequestDTO.get().getProductType());
		s.setServiceProviderId(serviceRequestDTO.get().getServiceProviderId());
		s.setAddressId(serviceRequestDTO.get().getAddressId());
		s.setUserId(serviceRequestDTO.get().getUserId());
		s.setLocalDate(serviceRequestDTO.get().getLocalDate());
		s.setPayment(serviceRequestDTO.get().getPayment());
		serviceRequestRepo.save(s);
		
		Visit visit=new Visit();
		
		visit.setServiceRequestId(visitDTO.getServiceRequestId());
		visit.setVisitingMessage(visitDTO.getVisitingMessage());
		LocalDate localDate = LocalDate.now();
		visit.setLocalDate(localDate);
		visitRepo.save(visit);
		return visitRepo.save(visit);
	}
	 private JavaMailSender javaMailSender;

//	    public RepairService(JavaMailSender javaMailSender) {
//	        this.javaMailSender = javaMailSender;
//	    }
	public String sendEmail() {
		 SimpleMailMessage mailMessage = new SimpleMailMessage();

	        mailMessage.setTo("kumarbhushansingh491@gmail.com");
	        mailMessage.setSubject("Hello Bhushan");
	        mailMessage.setText("I am bhushan");

	        mailMessage.setFrom("kumarbhushansingh491@gmail.com");

	        javaMailSender.send(mailMessage);
		
		return "sent";
		
	}
	public String sendPassword(ServiceProviderDTO serviceProviderDTO) {
		String pass=this.genrate();
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(serviceProviderDTO.getEmailId());
            helper.setText("Your login Id is your email Id"+"\n"+ "Your login password is: "+pass);
            helper.setSubject("Mail From Repair At Your Doorstep verification");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = passwordEncoder.encode(pass);
        
        
		serviceProviderRepo.update(serviceProviderDTO.getServiceProviderId(), encodedPassword);
     
        
        return "sent";
	}
	public String genrate() {
		Random random = new Random();
		String password="bushan";
		String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase=upperCase.toLowerCase();
		String special="!@#$%^&*><?/";
		String number="1234567890";
		password=""+upperCase.charAt(random.nextInt(26))+""+lowerCase.charAt(random.nextInt(26))
		+""+special.charAt(random.nextInt(12))+""+number.charAt(random.nextInt(10))+
		""+special.charAt(random.nextInt(12))+
		""+upperCase.charAt(random.nextInt(26))+""+lowerCase.charAt(random.nextInt(26))
		+""+special.charAt(random.nextInt(12))+""+number.charAt(random.nextInt(10))+
		""+special.charAt(random.nextInt(12));
		
		return password;
	}
	public List<ServiceProvider> varifyServiceProviderDetails(){
		return serviceProviderRepo.findByStatus(false);
	}
	public List getReviewOfServiceRequest(String userId) {
		int id=Integer.parseInt(userId);
		return serviceRequestRepo.requestDetails(id);
		
	}
	public List countType() {
		return serviceRequestRepo.countRequestType();
	}
	public List countTypeOfRequestForUser(String userId) {
		int id=Integer.parseInt(userId);
		return  serviceRequestRepo.countRequestTypeOfUser(id);
	}

	public ServiceProvider getSpProfile(int spId) { 
		return serviceProviderRepo.findByServiceProviderId(spId);
	}
	
	public void saveTechieData(TechnicianAddingDto technicianDtoObj) {
		ServiceProvider spObj = new ServiceProvider();
		Technician technician = new Technician();
		
		int spId = technicianDtoObj.getServiceProviderId();
		spObj = serviceProviderRepo.findByServiceProviderId(spId);
		
		List<Technician> techieList = new ArrayList<>();
		techieList = spObj.getTechnician();
		technician.setFirstName(technicianDtoObj.getFirstName());
		technician.setLastName(technicianDtoObj.getLastName());
		technician.setQualification(technicianDtoObj.getQualification());
		technician.setEmail(technicianDtoObj.getEmail());
		technician.setPhone_Number(technicianDtoObj.getPhone_Number());
		technician.setAddress(technicianDtoObj.getAddress());

		techieList.add(technician);
		
		spObj.setTechnician(techieList);
		serviceProviderRepo.save(spObj);
	}

	public ServiceProvider getTechnicianData(int spId) {
		return serviceProviderRepo.findByServiceProviderId(spId);
		
	}
	
	public List getInvoice(String serviceRequestId) {
		int id=Integer.parseInt(serviceRequestId);
		return serviceRequestRepo.getInvoiceDetails(id);
	} 
	
	public List<ServiceRequest> getPaymentStatus(String userId){
		int id=Integer.parseInt(userId);
		
		return serviceRequestRepo.findByUserIdWithPaymentStaus(id);
		
	}
	public String changePassword(ChangePasswordDTO changePasswordDTO) throws NotFound {
		Optional<User> user=userRepo.findByEmailId(changePasswordDTO.getEmailId());
		
		if(user.isPresent()) {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(changePasswordDTO.getCurrentPassword(),user.get().getPassword())){
				String newPassword=encoder.encode(changePasswordDTO.getNewPassword());
				userRepo.updatePassword(newPassword,user.get().getUserId());
				return "chnage";
				
			}
		}
		
		throw new NotFound();
	}
	public List<ServiceProvider> getAllServiceProviderDetails(){
		return (List<ServiceProvider>) serviceProviderRepo.findAll();
	}
	public List<User> getAllUserDetails() {
		return (List<User>) userRepo.findAll();
	}
	public List<ServiceRequest> getAllServiceRequestDetails() {
		return (List<ServiceRequest>) serviceRequestRepo.findAll();
		
	}
	

}
