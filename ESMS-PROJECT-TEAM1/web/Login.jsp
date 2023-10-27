<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="MainController" method="POST">
            Email:<input type="text" name="email"/><br/>
            Password:<input type="password" name="password"/><br/>
            <input type="submit" name="action" value="Login" /><br/>
        </form>
        <%
            String message = (String)request.getAttribute("MESSAGE");
            if(message == null){
                message = "";
            }
        %>
        <%=message%>
    </body>
</html>
