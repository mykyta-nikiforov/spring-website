<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">


<div class="container">
    <h3>Manage Groups</h3>
    <hr>
    <h4>Add new group</h4>
    <sf:form method="post" action="/admin/groups-manage/add-group" modelAttribute="newGroup">
        <input type="hidden" name="yearOfStudy" value="1">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Number</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="number"
                value="${newGroup.number}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Curator</label>
            <sf:select path="curator">
                <option value="">Select the curator</option>
                <c:forEach var="teacher" items="${teachers}">
                    <sf:option value="${teacher.id}">
                        <c:out value="${teacher.name} ${teacher.surname}"></c:out>
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
    <h3>List of Groups</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Number</th>
                <th>Curator</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="group" items="${groups}">
                <tr>
                    <td>
                        <a href="/admin/groups-manage/group-${group.id}">
                            ${group.number}
                        </a>
                    </td>
                    <td><a href="/admin/users-manage/teachers/${group.curator.id}">${group.curator.surname} ${group.curator.name} ${group.curator.patronymic}</a></td>
                    <td><a href="/admin/groups-manage/delete-group?id=${group.id}"><span class="oi oi-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="../../templates/footer.jsp"%>