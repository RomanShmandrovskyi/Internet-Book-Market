<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
    <div>
        <c:forEach var="aU" items="${allUsers}">
            <h3>${aU.name} ${aU.secondName}</h3>
            <p>Email: ${aU.email}</p>
            <p>Phone: ${aU.phone}</p>
            <p>Home address: ${aU.homeAdress}</p>
            <p><a href="/deleteUser/${aU.id}">Delete ${aU.name}</a></p>
            <p><a href="/allUserPurchases/${aU.id}">All ${aU.name}'s purchases</a></p>
            <p><a href="/editUser/${aU.id}">Edit this user</a></p>
            <br>
        </c:forEach>
    </div>
</body>
</html>
