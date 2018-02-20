<%@include file="templates/header.jsp"%>

<br>
<div class="container ">
    <h3>Edit course</h3>

    <sf:form method="post" action="update-course" modelAttribute="course">
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
                <sf:input type="text" class="form-control" path="description"
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
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lecture" items="${lectures}">
                <tr>
                    <td>${lecture.id}</td>
                    <td>${lecture.name}</td>
                    <td>${lecture.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<hr>
<div class="container ">
    <h3>Add new lecture</h3>
    <sf:form method="post" action="add-lecture" modelAttribute="newLecture">
        <input type="hidden" name="id" value="${newLecture.id}">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${newLecture.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="description"
                          value="${newLecture.description}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Add"/>
        </div>
    </sf:form>
</div>


<%@include file="templates/footer.jsp"%>