<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="main">
        <form action="/book/add" method="post">
            <div class="field">
                <label for="name">Name:</label>
                <input name="bookName" required id="name" type="text">
            </div>

            <div class="field">
                <label for="format">Format:</label>
                <input name="bookFormat" id="format" type="text">
            </div>

            <div class="field">
                <label for="language">Language:</label>
                <input name="bookLang" required id="language" type="text">
            </div>

            <div class="field">
                <label for="pageQual">Quality of pages:</label>
                <input name="bookPageQual" required id="pageQual" type="number">
            </div>

            <div class="field">
                <label for="price">Price:</label>
                <input name="bookPrice" required id="price" type="number">
            </div>

            <div class="field">
                <label for="producer">Producer:</label>
                <input name="bookProducer" required id="producer" type="text">
            </div>

            <div class="field">
                <label for="bookQual">Book quality:</label>
                <input name="bookQual" required id="bookQual" type="number">
            </div>

            <div class="field">
                <label for="description">Description:</label><br>
                <textarea name="bookDescr" id="description" type="text" cols="40" rows="5"></textarea>
            </div>

            <div class="field">
                <label for="author">Choose author:</label>
                <select required name="bookAuthor" id="author">
                    <option selected="selected" disabled>Set author:</option>
                    <c:forEach var="a" items="${authors}">
                        <option value="${a.id}">${a.name} ${a.surname}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="field">
                <label for="genre">Choose genre:</label>
                <select  required name="bookGenre" id="genre">
                    <option selected="selected" disabled>Set genre</option>
                    <c:forEach var="g" items="${genres}">
                        <option value="${g.id}">${g.genre}</option>
                    </c:forEach>
                </select>
            </div><br>

            <button type="submit">Add book!</button>
        </form>
    </div>
</body>
</html>
