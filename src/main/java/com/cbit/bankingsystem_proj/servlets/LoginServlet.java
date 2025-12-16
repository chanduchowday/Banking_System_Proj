package com.cbit.bankingsystem_proj.servlets;

import java.io.PrintWriter;

import com.cbit.bankingsystem_proj.dao.CustomerDaoImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/validatelogin")
public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
			res.setContentType("text/html");
			String name = req.getParameter("cusername");
			String pwd = req.getParameter("cpassword");
			
			CustomerDaoImpl cdaoImpl = new CustomerDaoImpl();
			String result[] = cdaoImpl.validateCredentials(name, pwd);
			System.out.println(result[1]);
			if(result[1].equals("Customer")) {
				HttpSession session = req.getSession(true);
				session.setAttribute("cid", result[0]);
				RequestDispatcher rd = req.getRequestDispatcher("customer.jsp");
				rd.forward(req, res);
			}else if(result[1].equals("Admin")) {
				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
				rd.forward(req, res);
			}else {
				PrintWriter pw = res.getWriter();
				pw.println("<h4 style='text-align:center;color:red'>Invalid Credentials</h4>");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, res);
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		doGet(req,res);
	}
}
