package com.example.repair.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_request")
public class ServiceRequest {
	
	@Id
	@GeneratedValue
	@Column(name = "service_request_id")
	private int serviceRequestId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "model_number")
	private String modelNumber;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	 @Enumerated(EnumType.ORDINAL)
	 private Status status;
    
    @Column(name = "product_image")
    private Blob productImage;
    
    @Column(name = "user_id")
    private int userId;

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Blob getProductImage() {
		return productImage;
	}

	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	
}
