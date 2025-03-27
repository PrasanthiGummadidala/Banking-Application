package com.servlet.bankregister;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/depositAction")
public class Deposit extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		CheckBalanceBean b=new CheckBalanceBean();
		
		b.setAccountNo(Integer.parseInt(request.getParameter("account")));
		
		b.setUserName(request.getParameter("username"));
		b.setPassword(request.getParameter("password"));
		b.setAmount(Integer.parseInt(request.getParameter("amount")));
		response.setContentType("text/html");
            DepositDAo d=new DepositDAo();
            int n = d.deposit(b);
            PrintWriter pw = response.getWriter();
            HttpSession s = request.getSession();
            s.setAttribute("deposit1", b);
            pw.println("<html><body text=red><center>");
		if(n>0) {
			request.getRequestDispatcher("deposit1.jsp").forward(request, response);
		}
		else {
			response.getWriter().println("<h1 style='color:red;'>Please check your username password</h1>");
			request.getRequestDispatcher("deposit.jsp").include(request, response);
		}
		pw.println("</center></body></html>");
	}

}















