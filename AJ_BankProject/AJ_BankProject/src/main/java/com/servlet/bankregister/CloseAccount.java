package com.servlet.bankregister;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/closeaccount")
public class CloseAccount extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    
		CheckBalanceBean c=new CheckBalanceBean();
		
		c.setAccountNo(Integer.parseInt(request.getParameter("accountno")));
		
		c.setUserName(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		
		CloseAcDao cd=new CloseAcDao();
		
		int n = cd.close(c); response.setContentType("text/html");
        HttpSession s = request.getSession();
        s.setAttribute("close", c);
        PrintWriter pw = response.getWriter();
		
        pw.println("<html><body text=red><center>");
		if(n>0) 
		{
			request.getRequestDispatcher("close.jsp").forward(request, response);
			
		}
		else {
			pw.println("<h1 style='color:red;'>Invalid UserName/Password</h1>");
			
			request.getRequestDispatcher("closeaccount.html").include(request, response);
			
		}
		pw.println("</center></body></html>");

	}

}
