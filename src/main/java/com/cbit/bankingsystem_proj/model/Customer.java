package com.cbit.bankingsystem_proj.model;

import java.sql.Timestamp;

public class Customer {

	private int customerId;
	private String name;
	private String email;
	private String contact;
	private String userName;
	private String password;
	private String address;
	private Timestamp createOn;
	
	public Customer() {
		
	}
	public Customer(int customerId, String name, String email, String contact, String userName, String password,
			String address, Timestamp createOn) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.createOn = createOn;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}
	
}
