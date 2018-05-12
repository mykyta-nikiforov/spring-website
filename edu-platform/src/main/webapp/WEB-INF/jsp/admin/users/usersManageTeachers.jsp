<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp" %>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container ">
    <h3>Manage Teachers</h3>
    <hr>
    <h4>Add new teacher</h4>
    <sf:form id="add-teacher-form" method="post">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="add-teacher-email"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="add-teacher-password"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="add-teacher-surname"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="add-teacher-name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="add-teacher-patronymic"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Degree</label>
            <select id="add-teacher-degree">
                <option value="">Select the degree</option>
                <%--<sf:options itemLabel="name" items="${}"></sf:options>--%>
                <c:forEach var="degree" items="${degrees}">
                    <option value="${degree.id}">
                        <c:out value="${degree.name}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="add-teacher-button" class="btn btn-dark" value="Add"/>
            </div>
            <div id="add-teacher-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Input all values, please.
            </div>
            <div id="add-teacher-added" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully added.
            </div>
        </div>
    </sf:form>
</div>


<div class="container text-center">
    <h3>Teachers</h3>
    <hr>
    <div class="table-responsive">
        <table id="teachers-table" class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Degree</th>
                <th>Delete</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td><a href="/admin/users-manage/teachers/${teacher.id}">${teacher.surname} ${teacher.name} ${teacher.patronymic}</a></td>
                    <td>${teacher.email}</td>
                    <td>${teacher.degree.name}</td>
                    <td>
                        <button teacher-id="${teacher.id}" class="remove-button btn btn-outline-danger">
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

<script src="../../../../static/js/admin/manageTeachers.js"></script>


<%@include file="../../templates/footer.jsp" %>