<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<html>
<head>
    <title>User list</title>
</head>
<body>

<%
List<User> testUsers = (List<User>) request.getAttribute("users");
if (testUsers == null || testUsers.isEmpty()) {
%>
    <p>No users found yet.</p>
<%
} else {
%>
    <table border="2">
        <tr>
            <td>ID</td>
            <td>Username</td>
            <td>Password</td>
            <td>Token</td>
            <td>Token Expired At</td>
            <td>Actions</td>
        </tr>
        <%
        for (User user : testUsers) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getToken() %></td>
                <td><%= user.getToken_expired_at() %></td>
                <td>
                    <form action="updateUser.jsp" method="post">
                        <input type="hidden" name="id" value="<%= user.getId() %>">
                        <input type="hidden" name="username" value="<%= user.getUsername() %>">
                        <input type="hidden" name="password" value="<%= user.getPassword() %>">
                        <input type="hidden" name="token" value="<%= user.getToken() %>">
                        <input type="hidden" name="tokenExpiredAt" value="<%= user.getToken_expired_at() %>">
                        <input type="submit" value="Modify" style="float:left">
                    </form>
                    <form action="deleteUser.jsp" method="post">
                        <input type="hidden" name="id" value="<%= user.getId() %>">
                        <input type="submit" value="Delete" style="float:left">
                    </form>
                </td>
            </tr>
        <%
        }
        %>
    </table>
<%
}
%>

<form action="addUser.jsp">
    <input type="submit" value="Add new user">
</form>
</body>
</html>
