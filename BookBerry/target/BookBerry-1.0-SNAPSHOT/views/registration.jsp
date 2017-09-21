<%--
  Created by IntelliJ IDEA.
  User: sh-ro
  Date: 30.03.2017
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>

    <div class="main">
        <form action="/registration" method="post">
            <div class="field">
                <label for="email">Email:</label>
                <input name="email" id="email" required type="email">
            </div>
            <div class="field">
                <label for="name">Name:</label>
                <input name="name" id="name" required type="text">
            </div>
            <div class="field">
                <label for="secondName">Second name:</label>
                <input name="secondName" required id="secondName" type="text">
            </div>
            <div class="field">
                <label for="phone">Phone:</label>
                <input name="phone" required id="phone" type="text"/>
            </div>
            <div class="field">
                <label for="password">Password:</label>
                <input name="password" required id="password" type="password">
            </div>
            <div class="field">
                <label for="passwordRep">Repeat password:</label>
                <input name="pass" required id="passwordRep" type="password">
            </div>
            <div class="field">
                <button type="submit">Registrate me!</button>
            </div>
        </form>
    </div>


</body>
</html>
