<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new author</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="main">
        <form action="/author/add" method="post">
            <div class="field">
                <label for="name">Name:</label>
                <input placeholder="name" name="authorName" required id="name" type="text">
            </div>

            <div class="field">
                <label for="surname">Surname:</label>
                <input placeholder="surname" name="authorSurname" required id="surname" type="text" >
            </div>

            <div class="field">
                <label for="birth">Birthday:</label>
                <input name="authorBirth" class="date" required id="birth" type="date">
            </div>

            <div class="field">
                <label for="country">Country:</label>
                <input name="authorCountry" required id="country" type="text">
            </div>

            <div class="field">
                <label for="description">Description:</label><br>
                <textarea required name="authorDescription" id="description" type="text" cols="40" rows="5"></textarea>
            </div>

            <div class="field">
                <button type="submit">Add author!</button>
            </div>
        </form>
    </div>
</body>
</html>
