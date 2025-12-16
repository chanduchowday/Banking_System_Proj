package com.cbit.bankingsystem_proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cbit.bankingsystem_proj.constants.QueryConstants;
import com.cbit.bankingsystem_proj.model.Account;
import com.cbit.bankingsystem_proj.util.DBConnectionUtil;

public class AccountDaoImpl implements IAccountDao{

	@Override
	public int createAccount(Account a) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int accountId = 0;
		ResultSet rs = null;
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt = con.prepareStatement(QueryConstants.ACCOUNT_REGISTER);
			pstmt.setString(1, a.getAccountType());
			pstmt.setString(2,a.getBranchName());
			pstmt.setDouble(3, a.getBalance());
			pstmt.setInt(4, a.getCustomerId());
			int i = pstmt.executeUpdate();
			if(i>0) {
				pstmt = con.prepareStatement(QueryConstants.ACCOUNT_ID);
				pstmt.setInt(1, a.getCustomerId());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					accountId = rs.getInt("a_id");
				}
			}else {
				accountId = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return accountId;
	}

	@Override
	public boolean depositAmount(double amount,int custId) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = DBConnectionUtil.createOracleConnection();
			pstmt1 = con.prepareStatement(QueryConstants.ACCOUNT_ID);
			pstmt1.setInt(1, custId);
			rs = pstmt1.executeQuery();
			if(rs.next()) {
				int accId = rs.getInt("a_id");
				System.out.println(accId);
				pstmt2 = con.prepareStatement(QueryConstants.DEPOSIT_AMOUNT);
				pstmt2.setString(1, "Deposit");
				pstmt2.setDouble(2, amount);
				pstmt2.setInt(3,accId);
				int i = pstmt2.executeUpdate();
				if(i>0) {
					pstmt3 = con.prepareStatement("update accounts set a_balance = a_balance+"+amount+" where c_id = ?");
					pstmt3.setInt(1, custId);
					pstmt3.executeUpdate();
					flag = true;
				}else {
					flag =false;
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return flag;
	}
}
