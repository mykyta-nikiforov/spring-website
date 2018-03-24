<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<link href="/static/css/bootstrap.min.css" rel="stylesheet">

<div class="container ">
    <h3>Manage Courses</h3>
    <hr>
    <h4>Add new course</h4>
    <form method="post" id="new-course-form">
        <input type="hidden" name="id" id="course-id">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" class="form-control" id="course-name" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <textarea type="text" class="form-control" id="course-desc" rows="5" required></textarea>
            </div>
        </div>
        <div class="form-group row">
            <input type="button" class="btn btn-dark" id="add-course-button" value="Add"/>
        </div>
        <div id="add-course-input-warning" class="alert alert-warning" role="alert"
             style="display: none">
            You should fill in all the inputs.
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
                <tr id="course-${course.id}">
                    <td>${course.id}</td>
                    <td><a href="/courses-manage/${course.id}">${course.name}</a></td>
                    <td>${course.description}</td>
                    <td><button course-id='${course.id}' class="remove-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="/static/js/teacher/coursesManage.js">
<%@include file="../templates/footer.jsp"%>