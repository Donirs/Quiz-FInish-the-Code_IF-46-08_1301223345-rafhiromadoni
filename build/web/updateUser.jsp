<%-- 
    Document   : updateUser
    Created on : 8 Dec 2024, 13.24.40
    Author     : rafhi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify user data</title>
</head>
<body>

Edit user

<form action="/QUIZ/users" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="username" value="${param.username}" placeholder=${param.username}>
    <input type="text" name="password" value="${param.password}" placeholder=${param.password}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Update">
</form>

</body>
</html>
