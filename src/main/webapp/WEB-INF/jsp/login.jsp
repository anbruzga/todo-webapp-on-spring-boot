<%@ include file="common/header.jspf" %>

<main>
    <div class="container">

        <div style="text-align: center;">
            <h4>Login Page</h4>
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

<%@ include file="common/footer.jspf" %>

