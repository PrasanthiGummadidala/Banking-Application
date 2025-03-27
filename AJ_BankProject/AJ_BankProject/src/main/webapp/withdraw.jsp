<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ICICI - BANK</title>
    <link rel="stylesheet" href="styles3.css">
    <script>
        function validateForm() {
            var account = document.forms["depositForm"]["account"].value;
            var username = document.forms["depositForm"]["username"].value;
            var password = document.forms["depositForm"]["password"].value;
            var amount = document.forms["depositForm"]["amount"].value;
            
            if (account == "" || username == "" || password == "" || amount == "") {
                alert("Fill out all fields");
                return false;
            }
            return true;
        }
    </script>
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
            <section class="services">
                <h2>Services</h2>
                <ul>
                    <li><a href="https://www.javatpoint.com">www.javatpoint.com</a></li>
                    <li><a href="https://www.javatpoint.com">www.javacstpoint.com</a></li>
                    <li><a href="https://www.javatpoint.com/forum.jsp">www.javatpoint.com/forum.jsp</a></li>
                </ul>
            </section>
            <section class="form-section">
                <h2>WITHDRAW FORM</h2>
                <form name="withdrawForm" action="abcd" method="post" onsubmit="return validateForm()">
                    <label for="account">ACCOUNT NO:</label>
                    <input type="text" id="account" name="account">
                    <label for="username">USER NAME:</label>
                    <input type="text" id="username" name="username">
                    <label for="password">PASSWORD:</label>
                    <input type="password" id="password" name="password">
                    <label for="amount">AMOUNT:</label>
                    <input type="text" id="amount" name="amount">
                    <input type="submit" value="Submit">
                    <input type="reset" value="CLEAR">
                </form>
            </section>
            <section class="welcome">
                <h2>Welcome</h2>
                <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTjnTzZZF9uhIze-NeIi45Gy_Du664IoDd4jRIVkWmKr4_LpSZr" alt="Welcome Image">
                <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign starting from business template, fashion template, media template, Science template, Arts template and much more.</p>
            </section>
        </main>
    </div>
</body>
</html>