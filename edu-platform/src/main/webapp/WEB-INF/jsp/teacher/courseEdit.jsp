<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<%--<link href="/static/css/style.css" rel="stylesheet">--%>


<br>
<div class="container ">
    <h3>Edit course</h3>

    <form method="post" id="edit-course-form">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="edit-course-name" class="form-control" value="${course.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <textarea type="text" id="edit-course-desc" class="form-control"
                          rows="5">${course.description}</textarea>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="edit-course-button" class="btn btn-dark" value="Save"/>
            </div>
            <div id="edit-course-input-warning" class="alert alert-warning alert-hide alert-small col-md-4" role="alert">
                Cannot be empty!
            </div>
            <div id="edit-course-input-updated" class="alert alert-success alert-hide alert-small col-md-4" role="alert">
                Successfully updated.
            </div>
        </div>
    </form>
</div>

<hr>

<div class="container text-center">
    <h3>Lectures</h3>
    <hr>
    <div class="table-responsive">
        <table id="lectures-table" class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lecture" items="${lectures}">
                <tr>
                    <td>${lecture.id}</td>
                    <td><a href="/courses-manage/${lecture.course.id}/edit-lecture/${lecture.id}">${lecture.name}</a></td>
                    <td><button lecture-id='${lecture.id}' class="remove-lecture-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<hr>

<div class="container text-center">
    <h3>Laboratory works</h3>
    <hr>
    <div class="table-responsive">
        <table id="labworks-table" class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="labWork" items="${labWorks}">
                <tr>
                    <td>${labWork.id}</td>
                    <td><a href="/courses-manage/${labWork.course.id}/edit-labwork/${labWork.id}">${labWork.name}</a></td>
                    <td><button labWork-id='${labWork.id}' class="remove-labwork-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<hr>
<div class="container ">
    <h3>Add new lecture</h3>
        <form method="post" id="new-lecture-form">
            <input type="hidden" name="courseId">
            <div class="form-group row">
                <label class="col-form-label col-md-3">Name</label>
                <div class="col-md-5">
                    <input type="text" id="add-lecture-name" class="form-control"/>
                </div>
            </div>
            <%--<div class="form-group row">--%>
                <%--<label class="col-form-label col-md-3">Description</label>--%>
                <%--<div class="col-md-5">--%>
                    <%--<sf:input type="text" class="form-control" path="description"--%>
                              <%--value="${newLecture.description}"/>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="form-group row">
                <input type="button" id="add-lecture-button" class="btn btn-dark" value="Add"/>
            </div>
            <div id="add-lecture-input-warning" class="alert alert-warning" role="alert"
                 style="display: none">
                This is a warning alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
            </div>
        </form>
</div>

<div class="container ">
    <h3>Add new laboratory work:</h3>
    <form method="post" id="new-labwork-form" >
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="add-labwork-name" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <input type="text" id="add-labwork-desc" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Deadline</label>
            <div class="col-md-5">
                <input type="date" id="add-labwork-deadline" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <input type="button" id="add-labwork-button" class="btn btn-dark" value="Add"/>
        </div>
        <div id="add-labwork-input-warning" class="alert alert-warning" role="alert"
             style="display: none">
            This is a warning alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
        </div>
    </form>
</div>

<script src="/static/js/teacher/courseEdit.js">

<%@include file="../templates/footer.jsp"%>