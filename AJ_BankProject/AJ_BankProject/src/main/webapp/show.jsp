<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ICICI- BANK</title>
    <link rel="stylesheet" href="styles4.css">
</head>
<body>
    <div class="container">
        <header>
            <div class="logo">
                <img src="https://media.licdn.com/dms/image/C4D12AQFs1vtNw0opUg/article-cover_image-shrink_720_1280/0/1520160366334?e=2147483647&v=beta&t=tsk7fbkBoI8SNfrW_aYZPnG3SgE3jmOmZ0hPhKO6PD4" alt="Logo">
            </div>
            <div class="title">
                <h1>ICICI - BANK</h1>
                <p>ExtraOrdinary Service</p>
            </div>
        </header>
        <nav>
            <ul>
                <li><a href="newaccount.html">NEW ACCOUNT</a></li>
                <li><a href="balance.html">BALANCE</a></li>
                <li><a href="deposit.jsp">DEPOSIT</a></li>
                <li><a href="withdraw.jsp">WITHDRAW</a></li>
                <li><a href="transfer.html">TRANSFER</a></li>
                <li><a href="closeaccount.html">CLOSE A/C</a></li>
                <li><a href="about.html">ABOUT US</a></li>
            </ul>
        </nav>
        <main>
            <section class="account-info">
                <h2>ACCOUNT INFORMATION</h2>
                <table>
                    <tr>
                        <td>ACCOUNT NO</td>
                        <td><%= request.getAttribute("accountNo") %></td>
                    </tr>
                    <tr>
                        <td>USERNAME</td>
                        <td><%= request.getAttribute("username") %></td>
                    </tr>
                    <tr>
                        <td>PASSWORD</td>
                        <td><%= request.getAttribute("password") %></td>
                    </tr>
                    <tr>
                        <td>AMOUNT</td>
                        <td><%= request.getAttribute("amount") %></td>
                    </tr>
                    <tr>
                        <td>ADDRESS</td>
                        <td><%= request.getAttribute("address") %></td>
                    </tr>
                    <tr>
                        <td>PHONE</td>
                        <td><%= request.getAttribute("phone") %></td>
                    </tr>
                </table>
            </section>
            <section class="services">
                <h2>SERVICES</h2>
                <ul>
                    <li><a href="https://www.javatpoint.com">www.javatpoint.com</a></li>
                    <li><a href="https://www.javatpoint.com">www.javacstpoint.com</a></li>
                    <li><a href="https://www.javatpoint.com/forum.jsp">www.javatpoint.com/forum.jsp</a></li>
                </ul>
            </section>
        </main>
    </div>
</body>
</html>