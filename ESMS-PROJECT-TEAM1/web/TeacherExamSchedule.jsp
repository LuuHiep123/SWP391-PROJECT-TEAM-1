<%-- 
    Document   : Teacher
    Created on : Oct 27, 2023, 8:46:42 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Exam Schedule</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER == null || sessionScope.USER.role ne 'Teacher'}">
            <c:redirect url="Login.jsp"></c:redirect>
        </c:if>

        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <c:if test="${sessionScope.TEACHER_EXAM_SCHEDULE != null}">
            <c:if test="${not empty sessionScope.TEACHER_EXAM_SCHEDULE}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Semester</th>
                            <th>Subject</th>
                            <th>Room</th>
                            <th>Slot</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="teacher" varStatus="counter" items="${sessionScope.TEACHER_EXAM_SCHEDULE}">
                        <form action="MainController" method="POST">

                            <tr>
                                <td>${counter.count}</td>
                                <td>${teacher.se_ID}</td>
                                <td>${teacher.subject_ID}</td>
                                <td>${teacher.room_ID}</td>
                                <td>${teacher.slot_ID}</td>

                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>                
        </c:if>

    </c:if>
</body>
</html>
