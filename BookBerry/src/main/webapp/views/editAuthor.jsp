<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit author</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="main">
        <form action="/editAuthor" method="post">
            <div class="field">
                <label for="userName">Name:</label>
                <input name="authorName" id="userName" type="text" value="${author.name}">
            </div>

            <div class="field">
                <label for="surname">Surname:</label>
                <input name="authorSurname" id="surname" type="text" value="${author.surname}">
            </div>

            <div class="field">
                <label for="authorBirth">Birthday:</label>
                <input name="authorBirth" id="authorBirth" type="date" value="${author.birthDate}">
            </div>

            <div class="field">
                <label for="authorCountry">Country:</label>
                <input name="authorCountry" id="authorCountry" type="text" value="${author.country}">
            </div>

            <div class="field">
                <label for="description">Description:</label><br>
                <textarea required name="authorDescription" id="description" type="text" cols="40" rows="5">${author.description}</textarea>
            </div>

            <input name="id" value="${author.id}" hidden>

            <div class="field">
                <button type="submit">Save!</button>
            </div>
        </form>
    </div>
</body>
</html>
