<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp" %>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container">
    <h4>Manage group ${group.number}</h4>
    <hr>
    <sf:form method="post" action="/admin/groups-manage/update" modelAttribute="group">
        <input type="hidden" name="id" value="${group.id}"/>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Number</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="number"
                          value="${group.number}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Specialty</label>
            <div class="col-md-5">${group.specialty.name}</div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Curator</label>
            <sf:select path="curator">
                <option value="${group.curator.id}">${group.curator.surname} ${group.curator.name} ${group.curator.patronymic}</option>
                <c:forEach var="teacher" items="${teachers}">
                    <%--Check in order to get rid of double showing the current curator of group--%>
                    <c:if test="${group.curator.id != teacher.id}">
                        <sf:option value="${teacher.id}">
                            <c:out value="${teacher.surname} ${teacher.name} ${teacher.patronymic}"></c:out>
                        </sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Update"/>
        </div>
    </sf:form>
    <a href="/admin/groups-manage/delete-group?id=${group.id}" class="btn btn-danger">Delete group</a>
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
                    <td><a href="/admin/users-manage/students/delete-student?id=${student.id}"><span
                            class="oi oi-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<%@include file="../../templates/footer.jsp" %>