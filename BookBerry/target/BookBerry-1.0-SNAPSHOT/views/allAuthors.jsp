<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>
    <c:forEach var="author" items="${author}">
        <h3>${author.name} ${author.surname}</h3>
        <p>Country: ${author.country}</p>
        <p>Birth: ${author.date}</p>
        <p>Description: ${author.description}</p>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p><a href="/author/edit/${author.id}">Edit this author</a></p>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p><a href="/delete/author/${author.id}">Delete this author</a></p>
        </sec:authorize>
    </c:forEach>
</body>
</html>
