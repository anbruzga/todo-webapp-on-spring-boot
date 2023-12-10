<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          crossorigin="anonymous">

    <link href="webjars\bootstrap-datepicker\1.10.0\css\bootstrap-datepicker.min.css"
          rel="stylesheet">

    <meta charset="UTF-8">

    <title>Add To Do's Page</title>
</head>
<body>
<div class="container">
<main>
    <div>
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">

            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" name="description" path="description" required="true"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="targetDate">Target Date</form:label>
                <form:input type="text" name="targetDate" path="targetDate" value="${targetDate}" required="true"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>

            <form:input type="hidden" name="done" path="done" />
            <form:input type="hidden" name="id" path="id"/>

            <input type="submit" class="btn btn-success">

        </form:form>
    </div>

</main>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        crossorigin="anonymous"></script>
<script src=https://code.jquery.com/jquery-3.7.1.js></script>

<script src=webjars\bootstrap-datepicker\1.10.0\js\bootstrap-datepicker.min.js></script>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
</body>
</html>