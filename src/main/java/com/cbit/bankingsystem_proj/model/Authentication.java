package com.cbit.bankingsystem_proj.model;

public class Authentication {

	private String userName;
	private String password;
	private String role;
	private int customerId;
	private String status;
	public Authentication(String userName, String password, String role, int customerId, String status) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.customerId = customerId;
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
