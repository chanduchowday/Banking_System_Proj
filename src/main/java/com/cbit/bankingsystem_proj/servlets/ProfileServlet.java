package com.cbit.bankingsystem_proj.servlets;

import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;
import com.cbit.bankingsystem_proj.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
			HttpSession session = req.getSession(false);
			String cid = (String)session.getAttribute("cid");//"1421"
			CustomerDaoImpl cDaoImpl = new CustomerDaoImpl();
			Customer c = cDaoImpl.getProfileById(Integer.parseInt(cid));//1421
			if(c!=null) {
				req.setAttribute("customer", c);
				RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
				rd.forward(req, res);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("failure.jsp");
				rd.forward(req, res);
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		doGet(req, res);
	}
}
