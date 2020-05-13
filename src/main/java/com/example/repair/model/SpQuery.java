package com.example.repair.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SpQuery {
	@Id
	@GeneratedValue
	private int queryId;
	private int serviceProviderId;
	private String serviceProviderName;
	private String spEmail;
	private String queryTitle;
	private String query;
	private Date queryDate;
	private boolean isSolved;
	private String adminMailText;
	
	public SpQuery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpQuery(int queryId, int serviceProviderId, String serviceProviderName, String spEmail, String queryTitle,
			String query, Date queryDate, boolean isSolved, String adminMailText) {
		super();
		this.queryId = queryId;
		this.serviceProviderId = serviceProviderId;
		this.serviceProviderName = serviceProviderName;
		this.spEmail = spEmail;
		this.queryTitle = queryTitle;
		this.query = query;
		this.queryDate = queryDate;
		this.isSolved = isSolved;
		this.adminMailText = adminMailText;
	}
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	public int getServiceProviderId() {
		return serviceProviderId;
	}
	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getSpEmail() {
		return spEmail;
	}
	public void setSpEmail(String spEmail) {
		this.spEmail = spEmail;
	}
	public String getQueryTitle() {
		return queryTitle;
	}
	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Date getQueryDate() {
		return queryDate;
	}
	public void setQueryTime(Date queryDate) {
		this.queryDate = queryDate;
	}
	public boolean isSolved() {
		return isSolved;
	}
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	public String getAdminMailText() {
		return adminMailText;
	}
	public void setAdminMailText(String adminMailText) {
		this.adminMailText = adminMailText;
	}
	
	
}