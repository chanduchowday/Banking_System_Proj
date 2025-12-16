package com.cbit.bankingsystem_proj.servlets;

import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;
import com.cbit.bankingsystem_proj.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectcustomer")
public class SelectCustomerServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			String id = req.getParameter("id");
			int cid = Integer.parseInt(id);
			
			CustomerDaoImpl cDaoImpl = new CustomerDaoImpl();
			Customer custObj = cDaoImpl.getProfileById(cid);
			if(custObj!=null) {
				req.setAttribute("c", custObj);
				RequestDispatcher rd = req.getRequestDispatcher("updatecustomer.jsp");
				rd.forward(req, res);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("failure.jsp");
				rd.forward(req, res);
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
