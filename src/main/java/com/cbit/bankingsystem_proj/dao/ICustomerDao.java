package com.cbit.bankingsystem_proj.dao;

import java.util.List;

import com.cbit.bankingsystem_proj.model.Authentication;
import com.cbit.bankingsystem_proj.model.Customer;

public interface ICustomerDao {
	public int registerCustomer(Customer c);
	public void saveCredentials(Authentication auth);
	public String[] validateCredentials(String name,String password);
	public Customer getProfileById(int custId);
	public List<Customer> getAllCustomers();
	public boolean deleteCustomerById(int id);
	public boolean updateCustomer(Customer c);
}
