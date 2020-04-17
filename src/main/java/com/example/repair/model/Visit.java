package com.example.repair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visiting_details")
public class Visit {
	
	@Id
	@GeneratedValue
	@Column(name = "visit_id")
	private int visitId;
	
	@Column(name = "service_request_id")
	private int serviceRequestId;
	
	@Column(name = "visiting_message")
	private String visitingMessage;

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getVisitingMessage() {
		return visitingMessage;
	}

	public void setVisitingMessage(String visitingMessage) {
		this.visitingMessage = visitingMessage;
	}
	
	
	

}
