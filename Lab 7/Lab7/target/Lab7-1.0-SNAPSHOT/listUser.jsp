<%-- 
    Document   : listUser
    Created on : 18 Jun 2024, 2:31:48 pm
    Author     : Zahier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/aa5de83a5b.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container mt-3">
            <table class="table">
                <thead class="table-dark text-center">
                    <tr>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><c:out value="${user.userID}" /></td>
                            <td><c:out value="${user.firstname}" /></td>
                            <td><c:out value="${user.lastname}" /></td>
                            <td class="text-center"><a href="UserServlet?action=edit&userID=<c:out value="${user.userID}" />"><i class="fa-solid fa-pen"></i></a></td>
                            <td class="text-center"><a href="UserServlet?action=delete&userID=<c:out value="${user.userID}" />"><i class="fa-solid fa-trash"></i></a></td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td colspan="5" class="text-center"><a href="UserServlet?action=insert"><i class="fa-solid fa-plus"></i></a></td>
                        </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>