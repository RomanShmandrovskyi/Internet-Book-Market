<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">

    <p><img src="resources/photo/logo.png" alt="BookBerry"></p>

    <sec:authorize access="isAnonymous()">
        <p>
            <a href="/loginpage">login</a>
            <a href="/registration">Registration page</a>
        </p>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p><a href="/Administrator">My cabinet</a></p>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_USER')">
        <p><a href="/MyCabinet">My cabinet</a></p>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <p><a href="/logout">logout</a></p>
    </sec:authorize>

</head>
<body>
    <sec:authorize access="isAuthenticated()">
        <p>Hello, ${currentUser.name} ${currentUser.secondName}</p>
    </sec:authorize>

    <p><a href="/allAuthors">Authors</a><a href="/genres/all">Genres</a></p>

    <sec:authorize access="isAuthenticated() and hasRole('ROLE_USER')">
        <p>
            <a href="/basket">
                <c:choose>
                    <c:when test="${bInB == null or bInB.size()==0}">
                        Basket
                    </c:when>
                    <c:otherwise>
                        Basket ${bInB.size()}
                    </c:otherwise>
                </c:choose>
            </a>
        </p>
    </sec:authorize>

    <c:forEach var="b" items="${books}">
        <b:choose>
            <b:when test="${b.bookQuality > 10}">
                <a href="/book/${b.id}">
                    <div class="book">
                        <h2>${b.name}</h2>
                        <p class="ever">${b.price}</p>
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
            </b:when>
            <b:when test="${b.bookQuality < 10 and b.bookQuality > 0}">
                <a href="/book/${b.id}">
                    <div class="book">
                        <h2>${b.name}</h2>
                        <p class="ever">${b.price}</p>
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
                            <sec:authorize access="permitAll()">
                                <p class="ever">Ends!</p>
                            </sec:authorize>
                        </p>
                    </div>
                </a>
            </b:when>
            <b:otherwise>
                <a href="/book/${b.id}">
                    <div class="book">
                        <h2>${b.name}</h2>
                        <p class="ever">${b.price}</p>
                        <p class="ever">${b.author.name} ${b.author.surname}</p>

                        <p class="ever">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/book/edit/${b.id}">Edit book</a>
                            </sec:authorize>
                        </p>

                        <p class="ever">
                            <sec:authorize access="permitAll()">
                                <p class="ever">Sold out!</p>
                            </sec:authorize>
                        </p>
                    </div>
                </a>
            </b:otherwise>
        </b:choose>
    </c:forEach>
</body>
</html>
