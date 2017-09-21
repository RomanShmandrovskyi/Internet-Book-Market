<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>

    <c:choose>
        <c:when test="${book.size() > 0}">
            <c:forEach var="b" items="${book}">
                <a href="/book/${b.id}">
                    <div class="book">
                        <h2>${b.name}</h2>
                        <p class="ever"> Price: ${b.price}</p>
                        <p class="ever">${b.author.name} ${b.author.surname}</p>

                        <p class="ever">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/book/edit/${b.id}">Edit book</a>
                            </sec:authorize>
                        </p>

                        <p class="ever">
                            <sec:authorize access="hasRole('ROLE_USER') or isAnonymous()">
                                <a href="/addToBasket/${b.id}">Add to basket!</a>
                            </sec:authorize>
                        </p>
                    </div>
                </a>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>There are no one book with this genre!</p>
        </c:otherwise>
    </c:choose>


</body>
</html>
