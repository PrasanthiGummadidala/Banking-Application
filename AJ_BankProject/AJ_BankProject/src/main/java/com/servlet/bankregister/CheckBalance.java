package com.servlet.bankregister;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/balanceForm")
public class CheckBalance extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountno");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        CheckBalanceBean b = new CheckBalanceBean();
        b.setAccountNo(Integer.parseInt(accountNo));
        b.setUserName(userName);
        b.setPassword(password);
        
      if (ValidateDAO.validate(b) > 0) {
            CheckBalanceDao b1 = new CheckBalanceDao();
            CheckBalanceBean detail = b1.ViewDetails(b);
            if(detail!=null)
            {
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<title>ICICI - BANK</title>");
            pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles2.css\">");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<div class='container'>");
            pw.println("<header>");
            pw.println("<div class='logo'><img src='https://media.licdn.com/dms/image/C4D12AQFs1vtNw0opUg/article-cover_image-shrink_720_1280/0/1520160366334?e=2147483647&v=beta&t=tsk7fbkBoI8SNfrW_aYZPnG3SgE3jmOmZ0hPhKO6PD4' alt='Logo'></div>");
            pw.println("<div class='title'><h1>ICICI - BANK</h1><p>ExtraOrdinary Service</p></div>");
            pw.println("</header>");
            pw.println("<nav><ul>");
            pw.println("<li><a href='newaccount.html'>NEW ACCOUNT</a></li>");
            pw.println("<li><a href='balance.html'>BALANCE</a></li>");
            pw.println("<li><a href='deposit.jsp'>DEPOSIT</a></li>");
            pw.println("<li><a href='#'>WITHDRAW</a></li>");
            pw.println("<li><a href='#'>TRANSFER</a></li>");
            pw.println("<li><a href='#'>CLOSE A/C</a></li>");
            pw.println("<li><a href='#'>ABOUT US</a></li>");
            pw.println("</ul></nav>");
            pw.println("<main>");
            pw.println("<section class='services'>");
            pw.println("<h2>Services</h2>");
            pw.println("<ul>");
            pw.println("<li><a href='https://www.javatpoint.com'>www.javatpoint.com</a></li>");
            pw.println("<li><a href='https://www.javatpoint.com\">www.javacstpoint.com</a></li>");
            pw.println("<li><a href='https://www.javatpoint.com/forum.jsp'>www.javatpoint.com/forum.jsp</a></li>");
            pw.println("</ul>");
            pw.println("</section>");
            pw.println("<section class='form-section'>");
            pw.println("<h2>Balance Details</h2>");
            pw.println("Welcome " + userName + "<br><br>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>ACCOUNT NO</th><th>USERNAME</th><th>AMOUNT</th><th>ADDRESS</th><th>PHONE</th></tr>");
            pw.println("<tr><td>" + detail.getAccountNo() + "</td><td>" + detail.getUserName() + "</td><td>" + detail.getAmount() + "</td><td>" + detail.getAddress() + "</td><td>" + detail.getPhone() + "</td></tr>");
            pw.println("</table>");
            pw.println("</section>");
            pw.println("</main>");
            pw.println("</div>");
            pw.println("</body>");
            pw.println("</html>");
        } else {
            pw.println("Please Check Username and Password");
        }
    }
}}
