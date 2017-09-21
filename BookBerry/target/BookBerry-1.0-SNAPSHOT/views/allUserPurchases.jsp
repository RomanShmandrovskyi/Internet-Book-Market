<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <title>All user purchases</title>
</head>
    <body>
        <c:choose>
            <c:when test="${empty allPurchases}">
                <p>Purchase list is empty</p>
            </c:when>
            <c:otherwise>
                <c:forEach var="p" items="${allPurchases}">
                    <h4>Purchase date: ${p.date}</h4>
                    <p>Order number: #${p.id}</p>
                    <p>Sum: ${p.purchaseSumm}$</p>
                    <c:forEach var="book" items="${p.bookList}">
                        <a href="/book/${book.id}">
                            <div class="book1">
                                <h3>${book.name}</h3>
                                <p>Price: ${book.price}$</p>
                            </div>
                        </a>
                    </c:forEach>
                    <a href="/deletePurchase/${p.id}">Delete this purchase</a><br><br>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
