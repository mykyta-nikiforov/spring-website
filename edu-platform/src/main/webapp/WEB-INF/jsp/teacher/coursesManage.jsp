<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">

<div class="container ">
    <h3>Manage Courses</h3>
    <hr>
    <h4>Add new course</h4>
    <%--<sf:form method="post" action="add-course" modelAttribute="course">--%>
        <%--<input type="hidden" name="id" id="course-id" value="${course.id}">--%>
        <%--<div class="form-group row">--%>
            <%--<label class="col-form-label col-md-3">Name</label>--%>
            <%--<div class="col-md-5">--%>
                <%--<sf:input type="text" class="form-control" id="course-name" path="name" value="${course.name}"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group row">--%>
            <%--<label class="col-form-label col-md-3">Description</label>--%>
            <%--<div class="col-md-5">--%>
                <%--<sf:textarea type="text" class="form-control" id="course-desc" rows="5" path="description"--%>
                       <%--value="${course.description}"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group row">--%>
            <%--<input type="submit" class="btn btn-dark" id="add-course-button" value="Add"/>--%>
        <%--</div>--%>
    <%--</sf:form>--%>
    <form method="post">
        <input type="hidden" name="id" id="course-id">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="course-name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <textarea type="text" class="form-control" id="course-desc" rows="5"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <input type="button" class="btn btn-dark" id="add-course-button" value="Add"/>
        </div>
    </form>
</div>

<hr>

<div class="container">
    <h3>Edit available courses</h3>
    <hr>

    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left" id="courses-table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="course" items="${allcourses}">
                <tr>
                    <td>${course.id}</td>
                    <td><a href="/courses-manage/${course.id}">${course.name}</a></td>
                    <td>${course.description}</td>
                    <td><a href="/delete-course?id=${course.id}"><span class="oi oi-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="/static/js/teacher/coursesManage.js">
<%@include file="../templates/footer.jsp"%>