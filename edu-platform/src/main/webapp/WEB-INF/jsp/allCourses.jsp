<%@include file="templates/header.jsp"%>

    <br>
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Hello, world!</h1>
        </div>
    </div>

    <br>
    <div class="container text-center">
        <h3>Courses</h3>
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
                    <c:forEach var="course" items="${courses}">
                        <tr>
                            <td>${course.id}</td>
                            <td>${course.name}</td>
                            <td>${course.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


<%@include file="templates/footer.jsp"%>