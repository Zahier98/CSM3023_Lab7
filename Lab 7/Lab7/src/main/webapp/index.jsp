<%-- 
    Document   : index
    Created on : 18 Jun 2024, 2:30:07 pm
    Author     : Zahier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample Perform CRUD Using Java Servlet</title>
    </head>
    <body>
        <h1>Sample Perform CRUD Using Java Servlet!</h1>
        <jsp:forward page="/UserServlet?action=listUser" />
    </body>
</html>