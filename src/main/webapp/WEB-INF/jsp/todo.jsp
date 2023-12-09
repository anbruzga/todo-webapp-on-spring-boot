<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Add To Do's Page</title>
</head>
<body>
<div class="container">
<main>
    <div>
        <h1>Enter Todo Details</h1>
        <form method="post">
            Description <input type="text" name="description"/>
            <input type="submit" class="btn btn-success">

        </form>
    </div>

</main>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        crossorigin="anonymous"></script>
<script src=https://code.jquery.com/jquery-3.7.1.js></script>
</body>
</html>