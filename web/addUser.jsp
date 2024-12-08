<%-- 
    Document   : addUser
    Created on : 8 Dec 2024, 13.19.25
    Author     : rafhi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form action = "/QUIZ/users" method="post">
    <input required type="text" name="username" placeholder="Username">
    <input required type="text" name="password" placeholder="Password">
    <input type="submit" value="Save">
</form>
</body>
</html>

