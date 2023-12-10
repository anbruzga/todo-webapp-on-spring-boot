<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<main>
    <div style="text-align: center;">
        <h4>Add/Modify Todo</h4>
        <hr>
    </div>

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
<%@ include file="common/footer.jspf" %>
<script src=webjars\bootstrap-datepicker\1.10.0\js\bootstrap-datepicker.min.js></script>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
