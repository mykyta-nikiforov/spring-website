<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>
<link href="/static/css/open-iconic-bootstrap.css" rel="stylesheet">


<br>
<div class="container ">
    <h3>Edit laboratory work:</h3>

    <sf:form method="post" action="/update-lecture" modelAttribute="lecture">
        <input type="hidden" name="id" value="${lecture.id}">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${lecture.name}"/>
            </div>
        </div>
        <%--<div class="form-group row">--%>
        <%--<label class="col-form-label col-md-3">Description</label>--%>
        <%--<div class="col-md-5">--%>
        <%--<sf:input type="text" class="form-control" path="description"--%>
        <%--value="${lecture.description}"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Save"/>
        </div>
    </sf:form>

    <h3>Download files</h3>
    <sf:form action="/uploadLectureFile" method="POST" enctype="multipart/form-data"
             modelAttribute="lectureFileInfo">

        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <sf:textarea type="text" class="form-control" rows="4" path="description"/>
            </div>
        </div>


        <sf:input type="hidden" path="lectureId" name="id" value="${lecture.id}" />
        <input type="file" name="file"/>
        <input type="submit" value="Upload"/>
    </sf:form>

    <h3>All files</h3>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
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
                    <td><a href="/deleteLectureFile?id=${lectureFile.id}"><span class="oi oi-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<%@include file="../templates/footer.jsp"%>