<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>

<div class="container">
    <div class="jumbotron jumbo-header">
        <h1 class="display-4">${lecture.name}</h1>
    </div>

    <embed id="pdf-container" width="100%" height="600px" src="" type="application/pdf">

    <h3 class="pt-4">Other lecture files</h3>
    <div class="table-responsive">
        <table id="files-table" class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>File name</th>
                <th>Description</th>
                <th>Content type</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lectureFile" items="${lectureFiles}">
                <tr>
                    <td><a href="/lecture-file?id=${lectureFile.id}" target="_blank">${lectureFile.fileName}</a></td>
                    <td>${lectureFile.description}</td>
                    <td>${lectureFile.contentType}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<script src="../../../static/js/student/lecturePage.js"></script>
<%@include file="../templates/footer.jsp"%>