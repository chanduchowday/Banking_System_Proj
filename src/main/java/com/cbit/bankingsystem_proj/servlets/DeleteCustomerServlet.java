package com.cbit.bankingsystem_proj.servlets;

import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletecustomer")
public class DeleteCustomerServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			String id = req.getParameter("id");
			int cid = Integer.parseInt(id);
			
			CustomerDaoImpl cDaoImpl = new CustomerDaoImpl();
			boolean flag = cDaoImpl.deleteCustomerById(cid);
			if(flag) {
				RequestDispatcher rd = req.getRequestDispatcher("/allcustomers");
				rd.forward(req, res);
			}else {
				
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
