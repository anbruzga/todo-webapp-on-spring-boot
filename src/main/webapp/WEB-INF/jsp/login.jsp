<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<main>
    <h1>Bienvenue Sur La Page Page de Connexion!</h1>
    <form method="post">

        <label>
            Name: <input type="text" name="name">
        </label>
        <label>
            Password: <input type="password" name="password">
        </label>
        <input type="submit">
        <div>${errorMsg}</div>
    </form>
</main>
</body>
</html>