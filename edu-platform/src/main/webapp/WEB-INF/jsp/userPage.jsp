<%@include file="templates/header.jsp"%>

<div class="container">
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Email</th>
                <th>Password</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${userDetails.username}</td>
                <td>${userDetails.password}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<%@include file="templates/footer.jsp"%>