package com.cbit.bankingsystem_proj.servlets;

import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;
import com.cbit.bankingsystem_proj.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatecustomer")
public class UpdateCustomerServlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			String name = req.getParameter("cname");
			String email = req.getParameter("cemail");
			String contact = req.getParameter("contact");
			String username = req.getParameter("cusername");
			String password = req.getParameter("password");
			String address = req.getParameter("caddress");
			String id = req.getParameter("id");
			int cid = Integer.parseInt(id);
			
			Customer c = new Customer();
			c.setName(name);
			c.setEmail(email);
			c.setContact(contact);
			c.setUserName(username);
			c.setAddress(address);
			c.setCustomerId(cid);
			
			CustomerDaoImpl cDaoImpl = new CustomerDaoImpl();
			boolean flag = cDaoImpl.updateCustomer(c);
			if(flag) {
				RequestDispatcher rd = req.getRequestDispatcher("/allcustomers");
				rd.forward(req, res);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("failure.jsp");
				rd.forward(req, res);
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
