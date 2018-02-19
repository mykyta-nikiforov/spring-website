<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="templates/header.jsp"%>

<div class="container ">
    <h3>Manage Courses</h3>

    <sf:form method="post" action="addCourse" modelAttribute="course">
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
            <input type="submit" class="btn btn-dark" value="Add"/>
        </div>
    </sf:form>
</div>


<%@include file="templates/footer.jsp"%>