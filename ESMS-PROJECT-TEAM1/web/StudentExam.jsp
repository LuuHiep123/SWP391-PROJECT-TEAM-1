<%-- 
    Document   : examschudle-student
    Created on : Oct 28, 2023, 3:12:16 PM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.StudentExamDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exam Schedule Management System</title>

        <!-- link-favicon -->
        <link rel="icon" type="image/png" sizes="16x16" href="image/favicon.png">

        <!--link-Bootstrap CSS -->
        <link rel="preconnect" href="https://maxcdn.bootstrapcdn.com">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <!-- link-style -->
        <link rel="stylesheet" href="css/style-navbar.css">
        <link rel="stylesheet" href="css/style-exam_schudle.css">

        <!-- link-font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    </head>

    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("USER");
        %>
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
                                    <a class="nav-link" href="#">Exam Schedule</a>
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
                                                <span id="lblName" style="font-weight:bold;"><%=user.getName()%></span>
                                            </span>
                                            <span class="dropdown-item">
                                                Email:
                                                <span id="pnlEmail" style="font-weight:bold;"><%=user.getEmail()%></span>
                                            </span>
                                            <span class="dropdown-item">
                                                User's role: 
                                                <span id="lblRole" style="font-weight:bold;"><%=user.getRole()%></span>

                                            </span>
                                            <span class="dropdown-item">
                                            </span>
                                            <span class="dropdown-item">
                                                <a id="lbtnSignOut" style="text-decoration: none; display:inline-block;width:100%;"
                                                   href="LogoutController">Log out</a>
                                            </span>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <%
                String keysubject = request.getParameter("keysubject");
                if (keysubject == null) {
                    keysubject = "";
                }
            %>
            <form action="MainController">
                <input type="text" placeholder="Enter Key Subject" name="keysubject" value="<%=keysubject%>"/>
                <input type="submit" name="action" value="SearchKeySubject"/>
            </form>
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6 table">
                            <div class="exam-schedule" role="region" tabindex="0">
                                <%
                                    List<StudentExamDTO> ListExam = (List<StudentExamDTO>) session.getAttribute("LISTSTUDENTEXAM");
                                    if (ListExam != null) {
                                %>
                                <table>
                                    <caption>Exam Schedule:</caption>
                                    <thead>
                                        <tr>
                                            <th>Subjects</th>
                                            <th>Time</th>
                                            <th>Campus</th>
                                            <th>Date</th>
                                            <th>Room</th>
                                            <th>Form</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (StudentExamDTO exam : ListExam) {
                                        %>
                                        <tr>
                                            <td><%=exam.getSubjectID()%></td>
                                            <td><%=exam.getStartTime() + " " + "-" + " " + exam.getEndTime()%></td>
                                            <td><%=exam.getDate()%></td>
                                            <td><%=exam.getRoom()%></td>
                                            <td><%=exam.getCampus()%></td>
                                            <td><%=exam.getForm()%></td>
                                        </tr>    
                                        <%
                                            }
                                        %>
                                    <tbody>
                                </table>
                                <%
                                    }
                                %>
                            </div>
                        </div>

                        <div class="col-lg-6 link-container regulation">
                            <a href="#" class="show-text">Regulations</a>
                            <div class="hidden-text" id="hiddenText">
                                <iframe src="images/PDF/[SU23] Quy định thi Practical Exam (PE).pdf">
                                </iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <script src="js/script.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

</html>
