<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genres</title>
</head>
<body>
    <c:forEach var="g" items="${genres}">
        <p><a href="/books-from/${g.id}">${g.genre} (${g.bookList.size()})</a></p>
    </c:forEach>
</body>
</html>
