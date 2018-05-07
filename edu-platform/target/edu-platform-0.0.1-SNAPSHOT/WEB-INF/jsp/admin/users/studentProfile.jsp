<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container">
    <h3>Student Profile</h3>

    <sf:form method="post" action="/admin/users-manage/students/update" modelAttribute="student">
        <input type="hidden" name="id" value="${student.id}"/>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="email" value="${student.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="surname" value="${student.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${student.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="patronymic" value="${student.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Group</label>
            <sf:select path="group">
                <option value="${student.group.id}">${student.group.number}</option>
                <c:forEach var="group" items="${groups}">
                    <%--Check in order to get rid of double showing the current group of student--%>
                    <c:if test="${student.group.id != group.id}">
                        <sf:option value="${group.id}">
                            <c:out value="${group.number}"></c:out>
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
    <sf:form method="post" action="/admin/users-manage/students/update-password" modelAttribute="student">
        <input type="hidden" name="id" value="${student.id}"/>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <sf:input type="password" class="form-control" path="password"
                          value="${student.password}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Update password"/>
        </div>
    </sf:form>
    <a href="/admin/users-manage/students/delete-student?id=${student.id}" class="btn btn-danger">Delete student</a>
</div>

<%@include file="../../templates/footer.jsp"%>