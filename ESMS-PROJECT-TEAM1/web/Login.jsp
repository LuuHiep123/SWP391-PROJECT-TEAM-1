<%-- 
    Document   : login
    Created on : Oct 27, 2023, 10:14:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exam Schedule Management System</title>

        <!-- link-favicon -->
        <link rel="icon" type="images/png" sizes="16x16" href="images/favicon.png">

        <!-- link-reset-css -->
        <link rel="stylesheet" href="css/reset-css.css">

        <!-- link-style -->
        <link rel="stylesheet" href="css/style-login.css">

        <!-- link-font -->
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    </head>

    <body>
        <div class="login">
            <div class="thummail">
                <img src="images/background.png" alt="thummail-fptu">
            </div>

            <div class="themes-login">
                <div class="login_title">
                    <h1>Exam Schedule Management System</h1>
                </div>
                <div class="login_form">
                    <h3>Sign in</h3>
                    <form action="MainController" method="POST">
                        <div class="login-account">
                            <div class="input-group flex-nowrap">
                                <span class="input-group-text" id="addon-wrapping">Username</span>
                                <input type="text" class="form-control" placeholder="Email address" aria-label="Username"
                                       aria-describedby="addon-wrapping" name="email">
                            </div>
                            <div class="input-group flex-nowrap">
                                <span class="input-group-text" id="addon-wrapping">Password</span>
                                <input type="password" class="form-control" placeholder="Password sent in FPT gmail" aria-label="Username"
                                       aria-describedby="addon-wrapping" name="password">
                            </div>
                            <a href="home.jsp">
                                <button type="submit" name="action" value="Login">Login</button><br>
                            </a>
                        </div>
                    </form>
                    <%
                        String message = (String)request.getAttribute("MESSAGE");
                        if(message == null){
                            message = "";
                        }
                    %>
                    <%=message%>
                    <a class="btn_google" href="Home-Student.html">
                        <img src="images/google-icon.png" alt="icon-google">Login with Google</a> <br>
                    <a href="register.jsp">
                        <button style="margin-top: 40px;" type="submit">Create Account</button>
                    </a>   


                    <div class="contact">
                        <div class="btn_mail">
                            <a
                                href="mailto: sschcm@fe.edu.vn?cc=KHAOTHIHCM@fe.edu.vn&subject=Request Support From ESMS_(Sudent-fill-title-content-here)">
                                <img src="images/mail-forward.png" alt="mail-forward">
                            </a>
                        </div>
                        <div class="btn_hotline">
                            <a href="tel: 028.73005585">
                                <img src="images/phone-filled.png" alt="hotline">
                            </a>
                        </div>
                        <div class="btn_web">
                            <a href="https://hcmuni.fpt.edu.vn/" rel="noopener" target="_blank">
                                <img src="images/world-www.png" alt="website">
                            </a>
                        </div>
                    </div>

                    <div class="footer">
                        <p>© Powered by FPT University</p>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>

</html>
