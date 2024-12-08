<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="/QUIZ/auth" method="post">
        <input type="hidden" name="action" value="register">
        <label>Username:</label><br>
        <input type="text" name="username"><br><br>
        <label>Password:</label><br>
        <input type="password" name="password"><br><br>
        <button type="submit">Register</button>
    </form>
    <p style="color:red;">
        ${error}
    </p>
    <p>Already have an account? <a href="/QUIZ/login.jsp">Login here</a></p>
</body>
</html>
