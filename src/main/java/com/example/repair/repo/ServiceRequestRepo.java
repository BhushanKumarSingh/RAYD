package com.example.repair.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.repair.model.ServiceRequest;

@Repository
@Transactional
public interface ServiceRequestRepo extends CrudRepository<ServiceRequest, Integer>{

	List findByUserId(int userId);
	
//	@Modifying
//	@Query(
//	  value = 
//	    "insert into address(address_id,complete_address,current_location,pin_code,user_id,service_provider_id) values (:address_id,:complete_address,:current_location,:pin_code,:user_id,:service_provider_id)",
//	  nativeQuery = true)
//	void insertAddress(int user_id,int address_id,String complete_address,String current_location,int pin_code,int service_provider_id);

}
