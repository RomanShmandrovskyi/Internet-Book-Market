<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit book</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="main">
    <form action="/book/edit" method="post">
        <div class="field">
            <label for="bookName">Name:</label>
            <input name="name" id="bookName" type="text" value="${books.name}">
        </div>

        <div class="field">
            <label for="bookPrice">Price:</label>
            <input name="price" id="bookPrice" type="number" value="${books.price}">
        </div>

        <div class="field">
            <label for="pQ">Quantity of pages:</label>
            <input name="pQ" id="pQ" type="number" value="${books.pageQuality}">
        </div>

        <div class="field">
            <label for="format">Book format:</label>
            <input name="format" id="format" type="text" value="${books.format}">
        </div>

        <div class="field">
            <label for="lang">Book language:</label>
            <input name="lang" id="lang" type="text" value="${books.language}">
        </div>

        <div class="field">
            <label for="producer">Producer:</label>
            <input name="producer" id="producer" type="text" value="${books.producer}">
        </div>

        <div class="field">
            <label for="description">Description:</label><br>
            <textarea name="descr" id="description" cols="40" rows="5">${books.description}</textarea>
        </div>

        <div class="field">
            <label for="author">Choose author:</label>
            <select required name="bookAuthor" id="author">
                <option selected="selected" disabled>Set author</option>
                <c:forEach var="a" items="${authors}">
                    <option selected="${a.name} ${a.surname}" value="${a.id}">${a.name} ${a.surname}</option>
                </c:forEach>
            </select>
        </div>

        <div class="field">
            <label for="genre">Choose genre:</label>
            <select required name="bookGenre" id="genre">
                <option selected="selected" disabled>Set genre</option>
                <c:forEach var="g" items="${genres}">
                    <option selected="${g.genre}" value="${g.id}">${g.genre}</option>
                </c:forEach>
            </select>
        </div><br>

        <input name="id" id="id" type="text" value="${books.id}" hidden>
        <input name="bQ" id="bQ" type="text" hidden value="${books.bookQuality}"><br>
        <button type="submit">Edit!</button>
    </form>
    <a href="/deleteBook/${books.id}">Delete this book!</a>
</div>
</body>
</html>
