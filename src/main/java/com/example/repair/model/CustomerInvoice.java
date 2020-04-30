package com.example.repair.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CustomerInvoice {
	@Id
	@GeneratedValue
	private int invoiceId;
	private String spName;
	private String spCurrentLocation;
	private String spCompleteAddress;
	private int spPincode;
	private String repairProductName;
	private int orderId;
	private String customerEmailId;
	private String customerFirstName;
	private String customerLastName;
	private String customerCompleteAddress;
	private String customerCurrentLocation;
	private String customerPincode;
	
	@OneToMany(targetEntity = Parts.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "invoiceId",referencedColumnName = "invoiceId")
	private List<Parts> parts;

	public CustomerInvoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerInvoice(int invoiceId, String spName, String spCurrentLocation, String spCompleteAddress,
			int spPincode, String repairProductName, int orderId, String customerEmailId, String customerFirstName,
			String customerLastName, String customerCompleteAddress, String customerCurrentLocation,
			String customerPincode, List<Parts> parts) {
		super();
		this.invoiceId = invoiceId;
		this.spName = spName;
		this.spCurrentLocation = spCurrentLocation;
		this.spCompleteAddress = spCompleteAddress;
		this.spPincode = spPincode;
		this.repairProductName = repairProductName;
		this.orderId = orderId;
		this.customerEmailId = customerEmailId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerCompleteAddress = customerCompleteAddress;
		this.customerCurrentLocation = customerCurrentLocation;
		this.customerPincode = customerPincode;
		this.parts = parts;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpCurrentLocation() {
		return spCurrentLocation;
	}

	public void setSpCurrentLocation(String spCurrentLocation) {
		this.spCurrentLocation = spCurrentLocation;
	}

	public String getSpCompleteAddress() {
		return spCompleteAddress;
	}

	public void setSpCompleteAddress(String spCompleteAddress) {
		this.spCompleteAddress = spCompleteAddress;
	}

	public int getSpPincode() {
		return spPincode;
	}

	public void setSpPincode(int spPincode) {
		this.spPincode = spPincode;
	}

	public String getRepairProductName() {
		return repairProductName;
	}

	public void setRepairProductName(String repairProductName) {
		this.repairProductName = repairProductName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerCompleteAddress() {
		return customerCompleteAddress;
	}

	public void setCustomerCompleteAddress(String customerCompleteAddress) {
		this.customerCompleteAddress = customerCompleteAddress;
	}

	public String getCustomerCurrentLocation() {
		return customerCurrentLocation;
	}

	public void setCustomerCurrentLocation(String customerCurrentLocation) {
		this.customerCurrentLocation = customerCurrentLocation;
	}

	public String getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}

	public List<Parts> getParts() {
		return parts;
	}

	public void setParts(List<Parts> parts) {
		this.parts = parts;
	}
	
	
}
