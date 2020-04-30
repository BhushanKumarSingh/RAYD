package com.example.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Technician {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int technician_id;
	
	private String firstName;
	private String lastName;
	private String qualification;
	private String email;
	private String phone_Number;
	private String address;

	public Technician() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technician(int technician_id, String firstName, String lastName, String qualification, String email,
			String phone_Number, String address) {
		super();
		this.technician_id = technician_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.qualification = qualification;
		this.email = email;
		this.phone_Number = phone_Number;
		this.address = address;
	}

	public int getTechnician_id() {
		return technician_id;
	}

	public void setTechnician_id(int technician_id) {
		this.technician_id = technician_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
