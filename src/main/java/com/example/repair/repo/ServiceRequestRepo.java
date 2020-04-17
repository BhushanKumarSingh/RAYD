package com.example.repair.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.repair.model.ServiceRequest;
import com.example.repair.model.Status;

@Repository
@Transactional
public interface ServiceRequestRepo extends CrudRepository<ServiceRequest, Integer>{

	List findByUserId(int userId);
	
	@Query(value="select s.service_request_id,s.company_name,s.product_name,s.description,s.address_id,"
			+ "s.model_number,s.product_type,s.status,a.complete_address,a.current_location,"
			+ "a.pin_code,s.user_id,u.first_name,u.last_name,u.email_id,u.phone_number"
			+ " from service_request s INNER JOIN address a ON s.address_id=a.address_id INNER JOIN user u ON u.user_id=s.user_id and s.service_provider_id=?1", nativeQuery = true)
	List findByServiceProviderId(int serviceProviderId);

	List findByStatus(Status open);

	
//	@Modifying
//	@Query(
//	  value = 
//	    "insert into address(address_id,complete_address,current_location,pin_code,user_id,service_provider_id) values (:address_id,:complete_address,:current_location,:pin_code,:user_id,:service_provider_id)",
//	  nativeQuery = true)
//	void insertAddress(int user_id,int address_id,String complete_address,String current_location,int pin_code,int service_provider_id);
	@Query(value="select s.service_request_id,s.company_name,s.product_name,s.description,s.address_id,"
			+ "s.model_number,s.product_type,s.status,a.complete_address,a.current_location,"
			+ "a.pin_code,s.user_id "
			+ "from service_request s INNER JOIN address a ON s.address_id=a.address_id and (status=0)", nativeQuery = true)
	List getOpenRequestWithAddress();

}
