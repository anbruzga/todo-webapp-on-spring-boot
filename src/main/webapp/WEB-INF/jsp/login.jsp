<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<main>
    <div class="container">

        <div style="text-align: center;">
            <h4>Bienvenue Sur La Page d'Accueil, ${name}!</h4>
            <hr>
        </div>
        <form method="post">
            <pre>${errorMsg}</pre><br>
            <label>
                Name: <input type="text" name="name">
            </label>
            <label>
                Password: <input type="password" name="password">
            </label>
            <input type="submit">

        </form>
    </div>
</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        crossorigin="anonymous"></script>
<script src=https://code.jquery.com/jquery-3.7.1.js></script>

</body>
</html>