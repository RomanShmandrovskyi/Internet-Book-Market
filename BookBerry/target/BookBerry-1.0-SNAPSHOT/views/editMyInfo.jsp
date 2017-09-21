<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit my information</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>

    <div class="main">
        <form action="/saveMyInfo" method="post">
            <div class="field">
                <label for="name">Name:</label>
                <input name="name" id="name" type="text" value="${user.name}">
            </div>

            <div class="field">
                <label for="secondName">Second name:</label>
                <input name="secondName" id="secondName" type="text" value="${user.secondName}">
            </div>

            <div class="field">
                <label for="email">Email:</label>
                <input name="email" id="email" type="text" value="${user.email}"/>
            </div>

            <div class="field">
                <label for="phone">Phone:</label>
                <input name="phone" id="phone" type="text" value="${user.phone}">
            </div>

            <div class="field">
                <label for="pass">Password:</label>
                <input name="password" id="pass" type="password">
            </div>

            <div class="field">
                <label for="adr">Home address:</label>
                <input name="homeAdress" id="adr" type="text" value="${user.homeAdress}">
            </div>

            <input name="id" type="text" hidden value="${user.id}">

            <div class="field">
                <button type="submit">Save</button>
            </div>
        </form>
    </div>
</body>
</html>
