<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Cabinet</title>
</head>
    <body>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p><a href="/newGenre">Add new genre!</a></p>
    </sec:authorize>

    <c:choose>
        <c:when test="${genres.size() > 0}">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <p><a href="/newAuthor">Add new Author!</a></p>
            </sec:authorize>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${authors.size() > 0}">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <p><a href="/book/add">Add new book!</a></p>
            </sec:authorize>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${users.size() > 0}">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <p><a href="/allUsers">All Users</a></p>
            </sec:authorize>
        </c:when>
    </c:choose>
    </body>
</html>
