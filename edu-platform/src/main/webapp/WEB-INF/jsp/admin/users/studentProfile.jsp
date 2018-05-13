<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<script src="/static/js/admin/studentProfile.js"></script>

<div class="container">
    <h3>Student Profile</h3>

    <form>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <input type="text" id="update-student-email" class="form-control" value="${student.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <input type="text" id="update-student-surname" class="form-control" value="${student.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="update-student-name" class="form-control" value="${student.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <input type="text" id="update-student-patronymic" class="form-control" value="${student.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Group</label>
            <select id="update-student-group">
                <option value="${student.group.id}">${student.group.number}</option>
                <c:forEach var="group" items="${groups}">
                    <%--Check in order to get rid of double showing the current group of student--%>
                    <c:if test="${student.group.id != group.id}">
                        <option value="${group.id}">
                            <c:out value="${group.number}"></c:out>
                        </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="update-student-button" class="btn btn-dark" value="Update"/>
            </div>
            <div id="update-student-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Input all values, please.
            </div>
            <div id="update-student-success" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully added.
            </div>
        </div>
    </form>
</div>

<div class="container">
    <h3>Set new password:</h3>
    <form>
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

    <input type="button" id="delete-student-button" class="btn btn-danger" value="Delete student">
</div>

<%@include file="../../templates/footer.jsp"%>