<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp" %>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container">
    <h3>Manage group ${group.number}</h3>

    <form method="post" action="/admin/groups-manage/update">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Number</label>
            <div class="col-md-5">
                <input type="text" id="edit-group-number" class="form-control" value="${group.number}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Specialty</label>
            <div id="edit-group-specialty" class="col-md-5">${group.specialty.name}</div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Curator</label>
            <select id="edit-group-curator">
                <option value="${group.curator.id}">${group.curator.surname} ${group.curator.name} ${group.curator.patronymic}</option>
                <c:forEach var="teacher" items="${teachers}">
                    <%--Check in order to get rid of double showing the current curator of group--%>
                    <c:if test="${group.curator.id != teacher.id}">
                        <option value="${teacher.id}">
                            <c:out value="${teacher.surname} ${teacher.name} ${teacher.patronymic}"></c:out>
                        </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="edit-group-button" class="btn btn-dark" value="Update"/>
            </div>
            <div id="edit-group-input-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Cannot be empty!
            </div>
            <div id="edit-group-input-updated" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully updated.
            </div>
        </div>
    </form>
    <input type="button" id="delete-group-button" class="btn btn-danger" value="Delete group">


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
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.email}</td>
                    <td>
                        <a href="/admin/users-manage/students/${student.id}">${student.surname} ${student.name} ${student.patronymic}</a>
                    </td>
                    <%--<td><a href="/admin/users-manage/students/delete-student?id=${student.id}"><span--%>
                            <%--class="oi oi-trash"></span></a></td>--%>
                    <td><button student-id='${student.id}' class="remove-student-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="/static/js/admin/groupManage.js"></script>

<%@include file="../../templates/footer.jsp" %>