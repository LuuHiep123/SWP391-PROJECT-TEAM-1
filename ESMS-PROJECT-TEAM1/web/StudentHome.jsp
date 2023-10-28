<%-- 
    Document   : home
    Created on : Oct 28, 2023, 3:03:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Home</title>

    <!-- link-favicon -->
    <link rel="icon" type="images/png" sizes="16x16" href="images/favicon.png">

    <!-- link-icon -->
    <link rel="preconnect" href="https://cdn.linearicons.com">
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">

    <!--link-Bootstrap CSS -->
    <link rel="preconnect" href="https://maxcdn.bootstrapcdn.com">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- link-style -->
    <link rel="stylesheet" href="css/style-contact.css">

    <!-- link-font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
</head>

<body>
    <div class="container-fluid">
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-logo" href="home.jsp"><img src="images/fpt-favicon.png" alt="Logo"
                            width="70"></a>
                    <p class="navbar-title">Exam Schedule Management System</p>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    </button>
                    
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item item-menu">
                                <a class="nav-link" href="home.jsp">Home</a>
                            </li>
                            <li class="nav-item item-menu">
                                <a class="nav-link" href="StudentExam.jsp">Exam Schedule</a>
                            </li>
                            <li class="nav-item item-menu">
                                <a class="nav-link" href="contact.jsp">Contact</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                    <img id="ProfileImage" class="rounded-circle" style="height:40px;width:40px"
                                        src="https://i.chungta.vn/2023/03/02/-7802-1677731962.jpg" alt="avatar-profile">
                                </a>
                                <div class="dropdown-menu dropdown-menu-left">
                                    <div id="pnlProfile">
                                        <span class="dropdown-item">
                                            Name:
                                            <span id="lblName" style="font-weight:bold;">FPT Nguyen</span>
                                        </span>
                                        <span class="dropdown-item">
                                            Email:
                                            <span id="pnlEmail" style="font-weight:bold;">fptnguyen0@fpt.edu.vn</span>
                                        </span>
                                        <span class="dropdown-item">
                                            User's role:
                                            <span id="lblRole" style="font-weight:bold;">CEO</span>

                                        </span>
                                        <span class="dropdown-item">
                                        </span>
                                        <span class="dropdown-item">
                                            <a id="lbtnSignOut"
                                                style="text-decoration: none;display:inline-block;width:100%;"
                                                href="login.jsp">Log out</a>
                                        </span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container">
            <section class="contact">
                <div class="container">
                    <h1>Welcome to Home Page</h1>
                </div>
            </section>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>-->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
