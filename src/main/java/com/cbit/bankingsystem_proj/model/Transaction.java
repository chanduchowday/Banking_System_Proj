package com.cbit.bankingsystem_proj.model;

import java.sql.Timestamp;

public class Transaction {

	private int txId;
	private String txType;
	private double txAmount;
	private int accountId;
	private Timestamp txDate;
	
	public Transaction(int txId, String txType, double txAmount, int accountId, Timestamp txDate) {
		super();
		this.txId = txId;
		this.txType = txType;
		this.txAmount = txAmount;
		this.accountId = accountId;
		this.txDate = txDate;
	}
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public String getTxType() {
		return txType;
	}
	public void setTxType(String txType) {
		this.txType = txType;
	}
	public double getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Timestamp getTxDate() {
		return txDate;
	}
	public void setTxDate(Timestamp txDate) {
		this.txDate = txDate;
	}
}
