<%@include file="templates/header.jsp"%>

<div class="container ">
    <h3>Manage Users</h3>
    <hr>
    <h4>Add new user</h4>
    <sf:form method="post" action="/admin/add-user" modelAttribute="newUser">
        <input type="hidden" name="id" value="${newUser.id}">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="email" value="${newUser.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="password"
                          value="${newUser.password}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Add"/>
        </div>
    </sf:form>
</div>

<div class="container text-center">
    <h3>Users</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Email</th>
                <th>Password</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="templates/footer.jsp"%>