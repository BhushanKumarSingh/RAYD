package com.example.repair.dto;

public class VisitDTO {
	private int visitId;
	private int serviceRequestId;
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
