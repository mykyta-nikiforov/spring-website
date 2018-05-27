<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<script src='/static/js/admin/teacherProfile.js'></script>

<div class="container">
    <h3>Teacher Profile</h3>

    <form>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <input type="text" id="update-teacher-email" class="form-control" value="${teacher.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <input type="text" id="update-teacher-surname" class="form-control" value="${teacher.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="update-teacher-name" class="form-control" value="${teacher.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <input type="text" id="update-teacher-patronymic" class="form-control" value="${teacher.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Degree</label>
            <select id="update-teacher-degree">
                <option value="${teacher.degree.id}">${teacher.degree.name}</option>
                <c:forEach var="degree" items="${degrees}">
                    <%--Check in order to get rid of double showing the current degree of teacher--%>
                    <c:if test="${teacher.degree.id != degree.id}">
                        <option value="${degree.id}">
                            <c:out value="${degree.name}"></c:out>
                        </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="update-teacher-button" class="btn btn-dark" value="Update"/>
            </div>
            <div id="update-teacher-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Input all values, please.
            </div>
            <div id="update-teacher-success" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully added.
            </div>
        </div>
    </form>
</div>

<div class="container">
    <h3>Set new password:</h3>
    <form method="post">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <input id="update-password-input" type="password" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="update-password-button" class="btn btn-dark" value="Update password"/>
            </div>
            <div id="update-password-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Input the value, please.
            </div>
            <div id="update-password-success" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully added.
            </div>
        </div>
    </form>

    <input type="button" id="delete-teacher-button" class="btn btn-danger" value="Delete teacher">
</div>

<%@include file="../../templates/footer.jsp"%>