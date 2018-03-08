<%@page pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container ">
    <h3>Manage Students</h3>
    <hr>
    <h4>Add new student</h4>
    <sf:form method="post" action="/admin/users-manage/students/add-student" modelAttribute="newStudent">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="email" value="${newStudent.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="password"
                          value="${newStudent.password}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${newStudent.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="surname" value="${newStudent.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="patronymic" value="${newStudent.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Group</label>
            <sf:select path="group">
                <option value="">Select the Group</option>
                <c:forEach var="group" items="${groups}">
                    <sf:option value="${group.id}">
                        <c:out value="${group.number}"></c:out>
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
    <h3>Students</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Group</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.email}</td>
                    <td>${student.surname} ${student.name} ${student.patronymic}</td>
                    <td>${student.group.number}</td>
                    <td><a href="/admin/users-manage/students/delete-student?id=${student.id}"><span class="oi oi-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="templates/footer.jsp"%>