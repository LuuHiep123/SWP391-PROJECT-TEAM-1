<%-- 
    Document   : contact
    Created on : Oct 28, 2023, 3:18:31 PM
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
    <link rel="icon" type="image/png" sizes="16x16" href="image/favicon.png">

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
                    <a class="navbar-logo" href="home.jsp"><img src="images/fpt-favicon.png" alt="Logo" width="70"></a>
                    <p class="navbar-title">Exam Schedule Management System</p>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item item-menu">
                                <a class="nav-link" href="home.jsp">Home</a>
                            </li>
                            <li class="nav-item item-menu">
                                <a class="nav-link" href="examschudle-student.jsp">Exam Schedule</a>
                            </li>
                            <li class="nav-item item-menu">
                                <a class="nav-link" href="#">Contact</a>
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
                                            <a id="lbtnSignOut" style="text-decoration: none;display:inline-block;width:100%;"
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
                <div class="contact-content">
                    <h1>Contacts Us</h1>
                    <p>If you have any questions, please contact the information below, thank you!</p>
                </div>
                
                <div class="row">
                    <div class="col-lg-4">
                        <div class="ModuleContent">
                            <div class="info">
                                <figure>
                                    <figcaption>STUDENT SERVICES CENTER</figcaption>
                                </figure>
                                <a href="#!">
                                    <span class="lnr lnr-map-marker"></span>
                                    Room 202 - FPT Campus HCM</a> <br>
                                <a href="tel:028.73005585">
                                    <span class="lnr lnr-phone-handset"></span>
                                    028.73005585
                                </a><br>
                                <a href="mailto: sschcm@fe.edu.vn?cc=KHAOTHIHCM@fe.edu.vn&subject=Request Support From ESMS_(sudent-fill-title-content-here)">
                                    <span class="lnr lnr-envelope"></span>
                                    sschcm@fe.edu.vn
                                </a> 
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="gg-map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1165.0101746095638!2d106.80923541685074!3d10.841012473743959!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752731176b07b1%3A0xb752b24b379bae5e!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBGUFQgVFAuIEhDTQ!5e0!3m2!1svi!2s!4v1696002917048!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
