package com.cbit.bankingsystem_proj.servlets;

import java.util.List;

import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;
import com.cbit.bankingsystem_proj.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/allcustomers")
public class AllCustomerServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
			CustomerDaoImpl cDaoImpl = new CustomerDaoImpl();
			List<Customer> cList = cDaoImpl.getAllCustomers();
			if(!cList.isEmpty()) {
				req.setAttribute("custList", cList);
				RequestDispatcher rd = req.getRequestDispatcher("allcustomers.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		doGet(req,res);
	}
}
