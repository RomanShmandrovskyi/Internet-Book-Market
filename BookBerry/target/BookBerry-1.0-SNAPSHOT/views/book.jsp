<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <p>${book.name}</p>
    <p>price: ${book.price}</p>
    <p>producer: ${book.producer}</p>
    <p>language: ${book.language}</p>

    <sec:authorize access="isAuthenticated()">
        <form action="/comment/add" method="post">
            <label for="comm">Add comment:</label><br>
            <textarea name="bookComment" id="comm" type="text" cols="60" rows="5"></textarea>
            <input hidden name="id" value="${book.id}"><br>
            <button type="submit">Add!</button>
        </form>
    </sec:authorize>

    <c:choose>
        <c:when test="${comments.size() == 0 or comments == null}">
            <p>This book hasn't any comments!</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="c" items="${comments}">
            <h4>${c.user.name} ${c.user.secondName}</h4>
            <p>${c.date}</p>
            <p>${c.comment}</p>
            <c:if test="${currentUser.id == c.user.id}">
                <a href="/comment/delete/${c.id}">Delete this comment</a>
            </c:if>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/comment/delete/${c.id}">Delete this comment</a>
            </sec:authorize>
        </c:forEach>

        </c:otherwise>
    </c:choose>


</body>
</html>
