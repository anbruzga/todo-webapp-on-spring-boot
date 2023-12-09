<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<main>
    <div style="text-align: center;">
        <h6>Bienvenue Sur La Page d'Accueil, ${name}!</h6>
        <hr>

    </div>

    <div> <h1>Your todo's are: </h1> </div>
    <table>
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


</main>
</body>
</html>