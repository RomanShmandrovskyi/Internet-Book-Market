<%--
  Created by IntelliJ IDEA.
  User: sh-ro
  Date: 31.03.2017
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <title>Login</title>
</head>
<body>
    <h1>Login page</h1>

    <div class="main">
        <form action="/loginproc" method="post">
            <p>Input your credentials</p>

            <div class="field">
                <label for="login">Login</label>
                <input name="username" id="login" type="text" placeholder="Login" required>
            </div>

            <div class="field">
                <label for="pass">Password</label>
                <input name="password" id="pass" type="password" placeholder="Password" required>
            </div>

            <div class="field">
                <button type="submit">Login</button>
            </div>
        </form>
    </div>
</body>
</html>
