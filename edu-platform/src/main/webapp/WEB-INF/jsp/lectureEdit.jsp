<%@page pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>

<br>
<div class="container ">
    <h3>Edit lecture</h3>

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
            <label class="col-form-label col-md-3">File name:</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" />
            </div>
        </div>

        <sf:input type="hidden" path="lectureId" name="id" value="${lecture.id}" />
        <input type="file" name="file"/>
        <input type="submit" value="Upload"/>
    </sf:form>
</div>

<%@include file="templates/footer.jsp"%>