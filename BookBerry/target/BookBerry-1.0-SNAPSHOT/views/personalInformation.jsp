<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Information</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>

    <p>Name: </p>
    <h4>${thisUser.name} ${thisUser.secondName}</h4>

    <p>Email: </p>
    <h4>${thisUser.email}</h4>

    <p>Phone: </p>
    <h4>${thisUser.phone}</h4>

    <p>Home address: </p>
    <h4>${thisUser.homeAdress}</h4>

    <a href="/personal-information/edit">Edit my personal information</a>

</body>
</html>
