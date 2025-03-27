package com.servlet.bankregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/transfered")
public class TransferServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CheckBalanceBean c=new CheckBalanceBean();
		c.setAccountNo(Integer.parseInt(request.getParameter("accountno")));
		c.setUserName(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		c.setTargetAcno(Integer.parseInt(request.getParameter("targetaccountno")));
		c.setAmount(Integer.parseInt(request.getParameter("amount")));
		TransferDao t=new TransferDao();
		 HttpSession s = request.getSession();
         s.setAttribute("deducted", c);
         PrintWriter pw = response.getWriter();
         response.setContentType("text/html");
         System.out.println(c);
         
         pw.println("<html><body text=Yellow><center>");
        
        	 
         
		try {
			int m = t.transfer(c);
			System.out.println("m="+m);
			
			if(m>0) {
				request.getRequestDispatcher("deducted.jsp").forward(request, response);
			}
			else if(m==-1) {
				pw.println("<h1 style='color:red;'>Insufficient Balance</h1>");
				request.getRequestDispatcher("transfer.html").include(request, response);
			}
			else if(m==-2) {
				pw.println("<h1 style='color:red;'>Sender Account not verfied</h1>");
				request.getRequestDispatcher("transfer.html").include(request, response);
			}
			else if(m==-3) {
				pw.println("<h1 style='color:red;'>Reciver Account Not Found</h1>");
				request.getRequestDispatcher("transfer.html").include(request, response);
			}
			else {
				pw.println("<h1 style='color:red;'>Please check your username/password</h1>");
				request.getRequestDispatcher("transfer.html").include(request, response);
			}
			pw.println("</body></html>");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
         
	}

}
