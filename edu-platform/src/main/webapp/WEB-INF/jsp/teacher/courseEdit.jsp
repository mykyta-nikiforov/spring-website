<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">


<br>
<div class="container ">
    <h3>Edit course</h3>

    <sf:form method="post" action="/update-course" modelAttribute="course">
        <input type="hidden" name="id" value="${course.id}">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${course.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <sf:textarea type="text" class="form-control" rows="5" path="description"
                          value="${course.description}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Save"/>
        </div>
    </sf:form>
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
                    <td><a href="/edit-lecture/${lecture.id}">${lecture.name}</a></td>
                    <%--<td><a href="/delete-lecture?id=${lecture.id}"><span class="oi oi-trash"></span></a></td>--%>
                    <td><button lecture-id='${lecture.id}' class="remove-button"><span><i class="oi oi-trash"></i></span></button></td>
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
        <table class="table table-bordered table-striped text-left">
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
                    <td><a href="/edit-labwork/${labWork.id}">${labWork.name}</a></td>
                    <%--<td><a href="/delete-labwork?id=${labWork.id}"><span class="oi oi-trash"></span></a></td>--%>
                    <td><button labWork-id='${labWork.id}' class="remove-button"><span><i class="oi oi-trash"></i></span></button></td>

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
                    <input type="text" id="lecture-name" class="form-control"/>
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
    <sf:form method="post" action="/add-labwork" modelAttribute="newLabWorkInfo">
        <input type="hidden" name="courseId" path="courseId" value="${newLabWorkInfo.courseId}">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${newLabWorkInfo.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="description"
                value="${newLabWorkInfo.description}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Deadline</label>
            <div class="col-md-5">
                <sf:input type="date" class="form-control" path="deadLine"
                          value="${newLabWorkInfo.deadLine}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Add"/>
        </div>
    </sf:form>
</div>

<script src="/static/js/teacher/courseEdit.js">

<%@include file="../templates/footer.jsp"%>