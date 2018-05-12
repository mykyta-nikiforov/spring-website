<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<script src="/static/js/admin/manageStudents.js"></script>

<div class="container ">
    <h3>Manage Students</h3>
    <hr>
    <h4>Add new student</h4>
    <form id="add-student-form">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <input id="add-student-email" type="text" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <input id="add-student-password" type="text" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input id="add-student-name" type="text" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <input id="add-student-surname" type="text" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <input id="add-student-patronymic" type="text" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Group</label>
            <select id="add-student-group">
                <option value="">Select the Group</option>
                <c:forEach var="group" items="${groups}">
                    <option value="${group.id}">
                        <c:out value="${group.number}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input id="add-student-button" type="button" class="btn btn-dark" value="Add"/>
            </div>
            <div id="add-student-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Input all values, please.
            </div>
            <div id="add-student-success" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully added.
            </div>
        </div>
    </form>
</div>

<div class="container text-center">
    <h3>Students</h3>
    <hr>
    <div class="table-responsive">
        <table id="students-table" class="table table-bordered table-striped text-left">
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
                    <td><a href="/admin/users-manage/students/${student.id}">${student.surname} ${student.name} ${student.patronymic}</a></td>
                    <td>${student.group.number}</td>
                    <td>
                        <button student-id="${student.id}" class="remove-button btn btn-outline-danger">
                            <span>
                                <i class="oi oi-trash"></i>
                            </span>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="../../templates/footer.jsp"%>