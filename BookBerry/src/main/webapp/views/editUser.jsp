<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="main">
    <form action="/editUser" method="post">
        <div class="field">
            <label for="userName">Name:</label>
            <input name="name" id="userName" type="text" value="${user.name}">
        </div>

        <div class="field">
            <label for="userSecName">Second name:</label><br>
            <input name="secondName" id="userSecName" type="text" value="${user.secondName}">
        </div>

        <p>Phone: ${user.phone}</p>
        <input name="phone" type="text" value="${user.phone}" hidden>
        <p>Email: ${user.email}</p>
        <input name="email" type="text" value="${user.email}" hidden>

        <input name="password" type="text" value="${user.password}" hidden>
        <input name="id" type="text" value="${user.id}" hidden>
        <input name="homeAdress" type="text" value="${user.homeAdress}" hidden>

        <button type="submit">Save!</button>
    </form>
</div>
</body>
</html>
