package com.cbit.bankingsystem_proj.model;

import java.sql.Timestamp;

public class Account {

	private int accountId;
	private String accountType;
	private String branchName;
	private double balance;
	private int customerId;
	private Timestamp createOn;
	public Account(int accountId, String accountType, String branchName, double balance, int customerId,
			Timestamp createOn) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.branchName = branchName;
		this.balance = balance;
		this.customerId = customerId;
		this.createOn = createOn;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Timestamp getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}
	
	
}
