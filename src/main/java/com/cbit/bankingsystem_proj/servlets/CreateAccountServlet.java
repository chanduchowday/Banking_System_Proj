package com.cbit.bankingsystem_proj.servlets;

import java.io.IOException;

import com.cbit.bankingsystem_proj.dao.AccountDaoImpl;
import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;
import com.cbit.bankingsystem_proj.model.Account;
import com.cbit.bankingsystem_proj.model.Authentication;
import com.cbit.bankingsystem_proj.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/createaccount")
public class CreateAccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String name = request.getParameter("cname");
		  String email = request.getParameter("cemail");
		  String contact = request.getParameter("contact");
		  String username = request.getParameter("cusername");
		  String password = request.getParameter("cpassword");
		  String address = request.getParameter("caddress");
		  
		  Customer customerObj = new Customer(0, name, email, contact, username, password, address, null);
		  CustomerDaoImpl cDaoImpl = new CustomerDaoImpl();
		  int cid = cDaoImpl.registerCustomer(customerObj);
		  
		  System.out.println("Customer Id: "+cid);
		  
		  String acctype = request.getParameter("atype");
		  String bname = request.getParameter("bname");
		  
		  Account accountObj = new Account(0, acctype, bname, 1000.00, cid, null);
		  AccountDaoImpl aDaoImpl = new AccountDaoImpl();
		  int aid = aDaoImpl.createAccount(accountObj);
		  
		  Authentication auth = new Authentication(username, password,"Customer",cid, "Active");
		  cDaoImpl.saveCredentials(auth);
		  
		  if(aid>0) {
			  RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			  request.setAttribute("uname", username);
			  request.setAttribute("accountid", aid);
			  rd.forward(request, response);
		  }else {
			  RequestDispatcher rd = request.getRequestDispatcher("failure.jsp");
			  rd.forward(request, response);
		  }
		  
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
