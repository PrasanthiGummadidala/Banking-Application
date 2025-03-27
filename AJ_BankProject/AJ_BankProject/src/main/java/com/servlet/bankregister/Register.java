package com.servlet.bankregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/acform")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		pw.println("<html><body text=Yellow><center>");
		response.setContentType("text/html");
	  try {
		RegisterBean r=new RegisterBean();
		CheckBalanceBean c=new CheckBalanceBean();
		Random ra=new Random();
		int acc=ra.nextInt(1000,9999);
		r.setAccountNo(acc);
		r.setUserName(request.getParameter("username"));
		r.setPassword(request.getParameter("password"));
		r.setRePassword(request.getParameter("re-password"));
		r.setAmount(Integer.parseInt(request.getParameter("amount")));
		r.setAddress(request.getParameter("address"));
		r.setPhone(Long.parseLong(request.getParameter("phone")));
		System.out.println(r.getPassword()+"  "+r.getRePassword());
		RegisterDao rd=new RegisterDao();
		
		
	
		
if(!(r.getPassword().equals(r.getRePassword()))) {
			
			
			pw.println("<h1 style='color:red;'> Password Not Matched</h1>");
			request.getRequestDispatcher("newaccount.html").include(request, response);
			
		}
		else {
			int n = rd.register(r);
			if(n>0) {
				int getacNo = rd.getacNo(r);
				request.setAttribute("accountNo", r.getAccountNo());
				request.setAttribute("username", r.getUserName());
				request.setAttribute("password", r.getPassword());
				request.setAttribute("amount", r.getAmount());
				request.setAttribute("address", r.getAddress());
				request.setAttribute("phone", r.getPhone());
				
				request.getRequestDispatcher("show.jsp").forward(request, response);
			
		}
		else if(n==-1) {
			pw.println("<h1 style='color:red;'>UserName Already Exist!!!</h1>");
			request.getRequestDispatcher("newaccount.html").include(request, response);
			
		}
		else {
			pw.println("<h1 style='color:red;'> Registration Failed </h1>");
			request.getRequestDispatcher("newaccount.html").include(request, response);
		}
		
		
		
	}
		
		
	  }
	  catch (Exception e) 
	  {
		  pw.print("<h1 style='color:red;'>Please put valid Data</h1>");
	
	}
	  pw.println("</body></html>");

}
}








