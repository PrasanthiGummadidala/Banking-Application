<%@page import="com.servlet.bankregister.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ICICI - BANK: WITHDRAW Confirmation</title>
    <style>
        body {
            background-color: #000;
            color: #fff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 800px;
            margin: auto;
            padding: 20px;
            text-align: center;
        }
        .header {
            background-color: #000;
            padding: 20px 0;
            margin-bottom: 20px;
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
            color: #fff;
        }
        .header p {
            margin: 0;
            font-size: 18px;
            color: #fff;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
            margin-bottom: 20px;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .content {
            background-color: #fff;
            color: #000;
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
        }
        .content h2 {
            background-color: red;
            padding: 10px;
            border-radius: 5px;
            color: #fff;
            display: inline-block;
        }
        .content p {
            margin: 20px 0;
            font-size: 18px;
        }
        .footer {
            margin-top: 20px;
        }
        .footer a {
            color: #fff;
            text-decoration: none;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo">
            <img src="https://media.licdn.com/dms/image/C4D12AQFs1vtNw0opUg/article-cover_image-shrink_720_1280/0/1520160366334?e=2147483647&v=beta&t=tsk7fbkBoI8SNfrW_aYZPnG3SgE3jmOmZ0hPhKO6PD4" alt="Logo" style="max-width: 100px; float: left;">
        </div>
        <div class="title">
            <h1>SASTA - BANK</h1>
            <p>ExtraOrdinary Service</p>
        </div>
    </div>
    <div class="navbar">
        <a href="newaccount.html">NEW ACCOUNT</a>
        <a href="balance.html">BALANCE</a>
        <a href="deposit.jsp">DEPOSIT</a>
        <a href="withdraw.jsp">WITHDRAW</a>
        <a href="transfer.html">TRANSFER</a>
        <a href="closeaccount.html">CLOSE A/C</a>
        <a href="about.html">ABOUT US</a>
    </div>
    <div class="container">
        <div class="content">
            <%
                CheckBalanceBean bb = (CheckBalanceBean) session.getAttribute("withdraw1");
            %>
            <h2>Account Info</h2>
            <p><%= "Your Balance is Decrease by " + bb.getAmount() %></p>
        </div>
        <div class="footer">
            <p>Services:</p>
            <p>
                <a href="https://www.javatpoint.com">www.javatpoint.com</a><br>
                <a href="https://www.javacspoint.com">www.javacspoint.com</a><br>
                <a href="https://www.javatpoint.com/forum.jsp">www.javatpoint.com/forum.jsp</a>
            </p>
        </div>
    </div>
</body>
</html>