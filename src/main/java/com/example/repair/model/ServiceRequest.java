package com.example.repair.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name = "problem_type")
	private String problemType;
	
	@Column(name = "problem")
	private String problem;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	 private ServiceRequestStatus status;
    public enum ServiceRequestStatus {
        ACCEPTED,
        NOT_ACCEPTED;
    }
    
    @Column(name = "product_image")
    private Blob productImage;
    
    @Column(name = "user_id")
    private int user_id;

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceRequestStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceRequestStatus status) {
		this.status = status;
	}

	public Blob getProductImage() {
		return productImage;
	}

	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
    
    
    
	

}
