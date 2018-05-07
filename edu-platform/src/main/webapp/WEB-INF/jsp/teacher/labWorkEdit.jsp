<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">

<br>
<div class="container ">
    <h3>Edit laboratory work:</h3>

    <form method="put" id="update-labwork-form">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="update-labwork-name" class="form-control"
                       value="${labWork.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <input type="text" id="update-labwork-desc" class="form-control"
                       value="${labWork.description}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Deadline</label>
            <div class="col-md-5">
                <input type="date" id="update-labwork-deadline" class="form-control"
                       value="${labWork.deadLine}"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="update-labwork-button" class="btn btn-dark" value="Save"/>
            </div>
            <div id="update-labwork-input-warning" class="alert alert-warning alert-hide col-md-4" role="alert">
                Cannot be empty!
            </div>
            <div id="update-labwork-input-updated" class="alert alert-success alert-hide col-md-4" role="alert">
                Successfully updated.
            </div>
        </div>

    </form>

    <h3>Download file</h3>
    <form method="POST" id="add-file-form" enctype="multipart/form-data">

        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <textarea type="text" id="add-file-desc" class="form-control" rows="4"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-4 offset-md-3">
                <input type="file" id="add-file-file"/>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="add-file-button" class="btn btn-dark" value="Upload"/>
            </div>
            <div id="add-file-input-warning" class="alert alert-warning alert-hide col-md-4" role="alert">
                Cannot be empty!
            </div>
            <div id="add-file-input-updated" class="alert alert-success alert-hide col-md-4" role="alert">
                Successfully downloaded.
            </div>
        </div>
    </form>

    <h3>All files</h3>
    <div class="table-responsive">
        <table id="files-table" class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Id</th>
                <th>File name</th>
                <th>Description</th>
                <th>Content type</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="labWorkFile" items="${labWorkFiles}">
                <tr>
                    <td>${labWorkFile.id}</td>
                    <td>${labWorkFile.fileName}</td>
                    <td>${labWorkFile.description}</td>
                    <td>${labWorkFile.contentType}</td>
                    <td><button labwork-file-id='${labWorkFile.id}' class="remove-labwork-file-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<script src="../../../static/js/teacher/labWorkEdit.js"></script>

<%@include file="../templates/footer.jsp"%>