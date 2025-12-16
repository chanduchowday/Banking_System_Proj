package com.cbit.bankingsystem_proj.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
		 HttpSession session = req.getSession(false);
		 if(session!=null) {
		   session.invalidate();//Clearing a session
		 }
		 RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		 rd.forward(req, res);
		}catch(Exception e) {e.printStackTrace();}
	}
}
