<%-- 
    Document   : AddTestingStaff
    Created on : Oct 29, 2023, 12:38:14 AM
    Author     : HoangNQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Email <input type="text" name="Email" required=""/></br>
            Account_ID <input type="text" name="Account_ID" required=""/> </br>
            Password <input type="text" name="Password" required=""/> </br>
            Name <input type="text" name="Name" required=""/> </br>
            Gender <input type="text" name="Gender" required=""/> </br>
            Address <input type="text" name="Address" required=""/> </br>
            Day of Birth <input type="date" name="DoB" required=""/> </br>
            Role Name <input type="text" name="RoleName" required=""/> </br>

            <button type="submit" name="action" value="FuctioneAddByAdminController">Add</button><br>
            
        </form>
    </body>
</html>
