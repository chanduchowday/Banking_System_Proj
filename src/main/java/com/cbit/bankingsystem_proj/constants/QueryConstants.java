package com.cbit.bankingsystem_proj.constants;

public interface QueryConstants {

	String CUSTOMER_REGISTER = "insert into customers(c_id,c_name,c_email,c_contact,c_username,c_password,c_address) values(CUSTOMER_SEQ.NEXTVAL,?,?,?,?,?,?)";
    String CSUTOMER_ID = "select c_id from customers where c_username = ?";
    String ACCOUNT_REGISTER = "insert into accounts(a_id,a_type,a_branch,a_balance,c_id) values(ACCOUNT_SEQ.NEXTVAL,?,?,?,?)";
    String ACCOUNT_ID = "select a_id from accounts where c_id=?";
    String CREDENTIALS_SAVE = "insert into AUTHENTICATION values(?,?,?,?,?)";
    String AUTH_VALIDATION = "select * from AUTHENTICATION where username = ? and password = ? and status='Active'";
    String PROFILE_CUSTOMER = "select * from customers where c_id=?";
    String ALL_CUSUTOMERS = "select * from customers";
    String DELETE_CUSTOMER = "delete from customers where c_id=?";
    String UPDATE_CUSTOMER = "update customers set c_name=?,c_email=?,c_contact=?,c_username=?,c_address=? where c_id=?";
    String UPDATE_USERNAME = "update authentication set username=? where c_id=?";
    String DEPOSIT_AMOUNT = "insert into transactions(tx_id,tx_type,tx_amount,a_id,c_id) values(TRANSACTIONS_SEQ.NEXTVAL,?,?,?,?)";
   
    
}
