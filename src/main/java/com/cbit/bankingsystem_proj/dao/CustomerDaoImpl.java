package com.cbit.bankingsystem_proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cbit.bankingsystem_proj.constants.QueryConstants;
import com.cbit.bankingsystem_proj.model.Authentication;
import com.cbit.bankingsystem_proj.model.Customer;
import com.cbit.bankingsystem_proj.util.DBConnectionUtil;

public class CustomerDaoImpl implements ICustomerDao{

	
	@Override
	public int registerCustomer(Customer c) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int customerId = 0;
		ResultSet rs = null;
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.CUSTOMER_REGISTER);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getContact());
			pstmt.setString(4, c.getUserName());
			pstmt.setString(5, c.getPassword());
			pstmt.setString(6, c.getAddress());
			
			int i = pstmt.executeUpdate();
			if(i>0) {
				pstmt = con.prepareStatement(QueryConstants.CSUTOMER_ID);
				pstmt.setString(1, c.getUserName());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					customerId = rs.getInt("c_id");
				}
			}else {
				customerId = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customerId;
	}

	@Override
	public void saveCredentials(Authentication auth) {
		Connection con = null;
		PreparedStatement pstmt = null;
	  try {
		  con = DBConnectionUtil.createOracleConnection();
		  pstmt = con.prepareStatement(QueryConstants.CREDENTIALS_SAVE);
		  pstmt.setString(1, auth.getUserName());
		  pstmt.setString(2, auth.getPassword());
		  pstmt.setInt(3, auth.getCustomerId());
		  pstmt.setString(4, auth.getStatus());
		  pstmt.setString(5, auth.getRole());
		  int i = pstmt.executeUpdate();
		  if(i>0) {
			  System.out.println("Credentials Saved");
		  }else {
			  System.out.println("Credentials Not Saved");
		  }
	  }catch(Exception e) {e.printStackTrace();}
	}

	@Override
	public String[] validateCredentials(String name, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int customerId = 0;
		String role = "";
		
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.AUTH_VALIDATION);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				customerId = rs.getInt("C_ID");
				role = rs.getString("ROLE");
			}
		}catch(Exception e) {e.printStackTrace();}
		String result[] = {String.valueOf(customerId),role};
		return result;
	}

	@Override
	public Customer getProfileById(int custId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer c = null;
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.PROFILE_CUSTOMER);
			pstmt.setInt(1, custId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				c = new Customer(custId, rs.getString("c_name"), rs.getString("c_email"), rs.getString("c_contact"), rs.getString("c_username"), "******", rs.getString("c_address"), rs.getTimestamp("createdon"));
			}
		}catch(Exception e) {e.printStackTrace();}
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> cList = new ArrayList<>();
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.ALL_CUSUTOMERS);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Customer c = new Customer(rs.getInt("c_id"), rs.getString("c_name"), rs.getString("c_email"), rs.getString("c_contact"), rs.getString("c_username"), "******", rs.getString("c_address"), rs.getTimestamp("createdon"));
			    cList.add(c);
			}
		}catch(Exception e) {e.printStackTrace();}
		return cList;
	}

	@Override
	public boolean deleteCustomerById(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.DELETE_CUSTOMER);
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			if(i>0) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e) {e.printStackTrace();}
		return flag;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.UPDATE_CUSTOMER);
			pstmt.setString(1, c.getName());
			pstmt.setString(2,c.getEmail());
			pstmt.setString(3, c.getContact());
			pstmt.setString(4, c.getUserName());
			pstmt.setString(5, c.getAddress());
			pstmt.setInt(6, c.getCustomerId());
			
			int i = pstmt.executeUpdate();
			if(i>0) {
				pstmt = con.prepareStatement(QueryConstants.UPDATE_USERNAME);
				pstmt.setString(1, c.getUserName());
				pstmt.setInt(2, c.getCustomerId());
				pstmt.executeUpdate();
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e) {e.printStackTrace();}
		return flag;
	}
}
