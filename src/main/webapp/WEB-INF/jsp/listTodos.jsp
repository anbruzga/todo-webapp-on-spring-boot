<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>To Do's Page</title>
</head>
<body>
<main>
    <div class="container">
        <div style="text-align: center;">
            <h4>Bienvenue Sur La Page d'Accueil, ${name}!</h4>
            <hr>
        </div>

        <div><h1>Your todo's are: </h1></div>
        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
            </tr>
            </thead>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        crossorigin="anonymous"></script>
<script src=https://code.jquery.com/jquery-3.7.1.js></script>
</body>
</html>