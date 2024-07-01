<%-- 
    Document   : user
    Created on : 18 Jun 2024, 2:35:32 pm
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
        <title>New Record</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-3">
            <h2>New Record</h2>
            <form name="formAddUser" action="UserServlet" method="post" class="mt-3">
                <div class="form-group">
                    <label for="userID">User ID:</label>
                    <input type="text" class="form-control" name="userID" id="userID" size="25" required>
                </div>
                <div class="form-group">
                    <label for="firstname">First Name:</label>
                    <input type="text" class="form-control" name="firstname" id="firstname" size="40">
                </div>
                <div class="form-group">
                    <label for="lastname">Last Name:</label>
                    <input type="text" class="form-control" name="lastname" id="lastname" size="40">
                </div>
                <div class="form-group">
                    <input type="hidden" name="action" value="insert">
                </div>
                <div class="d-flex justify-content-end">
                    <button type="reset" class="btn">Clear</button>
                <button type="submit" class="btn btndark">Submit</button>
                </div>
            </form>
        </div>
    </body>
</html>