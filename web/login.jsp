<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/QUIZ/auth" method="post">
        <input type="hidden" name="action" value="login">
        <label>Username:</label><br>
        <input type="text" name="username"><br><br>
        <label>Password:</label><br>
        <input type="password" name="password"><br><br>
        <button type="submit">Login</button>
    </form>
    <p style="color:red;">
        ${error}
    </p>
    <p>Don't have an account? <a href="/QUIZ/register.jsp">Register here</a></p>
</body>
</html>
