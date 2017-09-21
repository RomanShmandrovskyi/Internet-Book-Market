<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new genre</title>
</head>
<body>
    <div class="main">
        <form action="/genre/add" method="post">
                <label for="genre">Genre:</label>
                <input name="genre" required id="genre" type="text">

                <button type="submit">Add genre!</button>
        </form>
    </div>
</body>
</html>
