<%@page pageEncoding="UTF-8" %>
<%@include file="../../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<script src="/static/js/admin/manageGroups.js"></script>


<div class="container">
    <h3>Manage Groups</h3>
    <hr>
    <h4>Add new group</h4>
    <form id="add-group-form">
        <%--TODO--%>
        <input type="hidden" name="yearOfStudy" value="1">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Number</label>
            <div class="col-md-5">
                <input id="add-group-number" type="text" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Specialty</label>
            <select id="add-group-specialty">
                <option value="">Select the specialty</option>
                <c:forEach var="specialty" items="${specialties}">
                    <option value="${specialty.id}">
                        <c:out value="${specialty.name}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Curator</label>
            <select id="add-group-curator" >
                <option value="">Select the curator</option>
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.id}">
                        <c:out value="${teacher.name} ${teacher.surname}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input id="add-group-button" type="button" class="btn btn-dark" value="Add"/>
            </div>
            <div id="add-group-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Input all values, please.
            </div>
            <div id="add-group-success" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully added.
            </div>
        </div>
    </form>
</div>

<div class="container text-center">
    <h3>List of Groups</h3>
    <hr>
    <div class="table-responsive">
        <table id="groups-table" class="table table-bordered table-striped text-left">
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
                    <td>
                        <button group-id="${group.id}" class="remove-button btn btn-outline-danger">
                            <span><i class="oi oi-trash"></i></span>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="../../templates/footer.jsp"%>