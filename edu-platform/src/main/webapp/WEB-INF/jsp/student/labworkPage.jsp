<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>

<div class="container">
    <div class="jumbotron jumbo-header">
        <h1 class="display-4">${labWork.name}</h1>
        <p>${labWork.description}</p>
        <p>Deadline: ${labWork.deadLine}</p>
    </div>

    <h3 class="pt-4">Labwork files</h3>
    <div class="table-responsive">
        <table id="files-table" class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>File name</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="labWorkFile" items="${labWorkFiles}">
                <tr>
                    <td><a href="/labwork-file?id=${labWorkFile.id}" target="_blank">${labWorkFile.fileName}</a></td>
                    <td>${labWorkFile.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<%@include file="../templates/footer.jsp"%>