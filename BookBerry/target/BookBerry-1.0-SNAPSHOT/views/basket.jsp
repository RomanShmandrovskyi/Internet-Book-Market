<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: sh-ro
  Date: 07.04.2017
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
    <c:choose>
        <c:when test="${book.size() > 0}">
            <c:forEach var="b" items="${book}">
                <p>${b.name}</p>
                <p>${b.price}</p>
                <p>${b.description}</p>
                <p><a href="/deleteFromBasket/${b.id}">Delete from basket!</a></p><br>
            </c:forEach>
            <p>Purchase sum = ${purchaseSum}</p>
            <p><a href="/makePurchase">Buy!</a></p>
            <a href="/">Back to home</a>
        </c:when>
        <c:otherwise>
            <p>Basket is empty!</p>
            <a href="/">Make purchases!</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
