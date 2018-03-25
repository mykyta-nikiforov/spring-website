<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">


<br>
<div class="container ">
    <h3>Edit lecture</h3>

    <form method="put" id="update-lecture-form">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="update-lecture-name" class="form-control" value="${lecture.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="button" id="update-lecture-button" class="btn btn-dark" value="Save"/>
        </div>
        <div id="update-lecture-input-warning" class="alert alert-warning" role="alert"
             style="visibility: hidden; opacity: 0.0">
            Cannot be empty!
        </div>
        <div id="update-lecture-input-updated" class="alert alert-success" role="alert"
             style="visibility: hidden; opacity: 1.0">
            Successfully updated.
        </div>
    </form>

    <h3>Download files</h3>
    <form method="POST" id="add-file-form" enctype="multipart/form-data">

        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <textarea type="text" id="add-file-desc" class="form-control" rows="4"></textarea>
            </div>
        </div>

        <input type="file" id="add-file-file"/>
        <input type="button" id="add-file-button" class="btn btn-dark" value="Upload"/>
        <div id="add-file-input-warning" class="alert alert-warning" role="alert"
             style="visibility: hidden; opacity: 1.0">
            Cannot be empty!
        </div>
        <div id="add-file-input-updated" class="alert alert-success" role="alert"
             style="visibility: hidden; opacity: 1.0">
            Successfully updated.
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
            <c:forEach var="lectureFile" items="${lectureFiles}">
                <tr>
                    <td>${lectureFile.id}</td>
                    <td><a href="/displayLecture?id=${lectureFile.id}" target="_blank">${lectureFile.fileName}</a></td>
                    <td>${lectureFile.description}</td>
                    <td>${lectureFile.contentType}</td>
                    <td><button lecture-file-id='${lectureFile.id}' class="remove-lecture-file-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>


<script src="../../../static/js/teacher/lectureEdit.js"></script>

<%@include file="../templates/footer.jsp"%>