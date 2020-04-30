package com.example.repair.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.repair.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	Optional<User> findByEmailId(String emailId);

	List findAllByUserId(int i);

	Optional<User> findByUserId(int userId);

	
	

}
