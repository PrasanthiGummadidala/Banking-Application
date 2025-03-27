package com.servlet.bankregister;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/abcd")
public class Withdraw extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
   CheckBalanceBean b=new CheckBalanceBean();
		
		b.setAccountNo(Integer.parseInt(request.getParameter("account")));
		
		b.setUserName(request.getParameter("username"));
		b.setPassword(request.getParameter("password"));
		b.setAmount(Integer.parseInt(request.getParameter("amount")));
            WithdrawDao d=new WithdrawDao();
            int n = d.withdraw(b);
            response.setContentType("text/html");
            HttpSession s = request.getSession();
            s.setAttribute("withdraw1", b);
            PrintWriter pw = response.getWriter();
    		
		if(n>0) 
		{
			request.getRequestDispatcher("withdraw1.jsp").forward(request, response);
		}
		else if(n==-1) {
			pw.println("<html><body text=red><center>");
			pw.println("<h1 style='color:red;'>Insufficient Balance</h1>");
			pw.println("</center></body></html>");
			request.getRequestDispatcher("withdraw.jsp").include(request, response);
			
		}
		else {
			response.getWriter().println("<h1 style='color:red;'>Please check your username password</h1>");
			request.getRequestDispatcher("withdraw.jsp").include(request, response);
		}
	}
		
		
	}


