<%@page pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp" %>
<div class="container ">
    <h3>Manage Teachers</h3>
    <hr>
    <h4>Add new teacher</h4>
    <sf:form method="post" action="/admin/add-teacher" modelAttribute="newTeacher">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="email" value="${newTeacher.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="password"
                          value="${newTeacher.password}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="surname"
                          value="${newTeacher.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name"
                          value="${newTeacher.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="patronymic"
                          value="${newTeacher.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Degree</label>
            <sf:select path="degree">
                <sf:option value="">Select the degree</sf:option>
                <%--<sf:options itemLabel="name" items="${}"></sf:options>--%>
                <c:forEach var="degree" items="${degrees}">
                    <sf:option value="${degree.id}">
                        <c:out value="${degree.name}"></c:out>
                    </sf:option>
                </c:forEach>
            </sf:select>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Add"/>
        </div>
    </sf:form>
</div>


<div class="container text-center">
    <h3>Teachers</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Degree</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.surname}</td>
                    <td>${teacher.email}</td>
                    <td>${teacher.degree.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<%@include file="templates/footer.jsp" %>