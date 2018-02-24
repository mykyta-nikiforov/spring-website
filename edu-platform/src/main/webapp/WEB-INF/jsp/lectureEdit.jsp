<%@include file="templates/header.jsp"%>

<br>
<div class="container ">
    <h3>Edit lecture</h3>

    <sf:form method="post" action="/update-lecture" modelAttribute="lecture">
        <input type="hidden" name="id" value="${lecture.course.id}">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="name" value="${lecture.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Description</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="description"
                          value="${lecture.description}"/>
            </div>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Save"/>
        </div>
    </sf:form>
</div>

<%@include file="templates/footer.jsp"%>