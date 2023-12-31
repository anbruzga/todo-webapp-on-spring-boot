<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<main>
    <div class="container">
        <div style="text-align: center;">
            <h4>Todo List Page</h4>
            <hr>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update</a></td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add Todo</a>

    </div>

</main>

<%@ include file="common/footer.jspf" %>