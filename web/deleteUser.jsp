<%-- 
    Document   : deleteUser
    Created on : 8 Dec 2024, 13.20.01
    Author     : rafhi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>

Are you sure you want to delete the user ${param.id}?

<form action="/QUIZ/users" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

</body>
</html>
