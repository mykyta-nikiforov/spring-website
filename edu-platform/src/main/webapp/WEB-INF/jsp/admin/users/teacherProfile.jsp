<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container">
    <h3>Teacher Profile</h3>

    <sf:form method="post" action="/admin/users-manage/teachers/update" modelAttribute="teacher">
        <input type="hidden" name="id" value="${teacher.id}"/>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="email" value="${teacher.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="surname" value="${teacher.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${teacher.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="patronymic" value="${teacher.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Degree</label>
            <sf:select path="degreeId">
                <option value="${teacher.degreeId.id}">${teacher.degreeId.name}</option>
                <c:forEach var="degreeId" items="${degrees}">
                    <%--Check in order to get rid of double showing the current degreeId of teacher--%>
                    <c:if test="${teacher.degreeId.id != degreeId.id}">
                        <sf:option value="${degreeId.id}">
                            <c:out value="${degreeId.name}"></c:out>
                        </sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Update"/>
        </div>
    </sf:form>
</div>

<div class="container">
    <h3>Set new password:</h3>
    <sf:form method="post" action="/admin/users-manage/teachers/update-password" modelAttribute="teacher">
        <input type="hidden" name="id" value="${teacher.id}"/>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <sf:input type="password" class="form-control" path="password"
                          value="${teacher.password}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Update password"/>
        </div>
    </sf:form>

    <a href="/admin/users-manage/teachers/delete-teacher?id=${teacher.id}" class="btn btn-danger">Delete teacher</a>
</div>

<%@include file="../../templates/footer.jsp"%>