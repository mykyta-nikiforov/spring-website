<%@include file="templates/header.jsp"%>

<br>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">${course.name}</h1>
        <p>${course.description}</p>
    </div>
</div>

<div class="container text-center">
    <h3>Lectures</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>No</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lecture" items="${lectures}">
                <tr>
                    <td>${lecture.id}</td>
                    <td><a href="/course-${course.id}/${lecture.id}">${lecture.name}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<%@include file="templates/footer.jsp"%>