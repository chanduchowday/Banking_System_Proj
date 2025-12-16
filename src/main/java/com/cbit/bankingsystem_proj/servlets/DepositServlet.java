package com.cbit.bankingsystem_proj.servlets;

import java.io.PrintWriter;

import com.cbit.bankingsystem_proj.dao.AccountDaoImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			HttpSession session = req.getSession(false);
			String custid = (String)session.getAttribute("cid");
			int cid = Integer.parseInt(custid);
			String amount = req.getParameter("amount");
			double amt = Double.parseDouble(amount);
			
			AccountDaoImpl accDaoImpl = new AccountDaoImpl();
			boolean flag = accDaoImpl.depositAmount(amt, cid);
			if(flag) {
				pw.println("<h4 style='color:green;text-align:center'>Amount has been deposited successfully</h4>");
				RequestDispatcher rd = req.getRequestDispatcher("deposit.jsp");
				rd.include(req, res);
			}else {
				pw.println("<h4 style='color:red;text-align:center'>Deposit failed</h4>");
				RequestDispatcher rd = req.getRequestDispatcher("deposit.jsp");
				rd.include(req, res);
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
