<%@include file="templates/header.jsp"%>

<div class="container">
    <h3>Manage Groups</h3>
    <hr>
    <h4>Add new group</h4>
    <sf:form method="post" action="/admin/add-group" modelAttribute="newGroup">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Number</label>
            <div class="col-md-5">
                <sf:input type="text" class="form-control" path="number"
                value="${newGroup.number}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Curator</label>
            <%--<div class="col-md-5">--%>
                <%--<sf:input type="text" class="form-control" path="curator"--%>
                          <%--value="${newGroup.curator}"/>--%>
            <%--</div>--%>
            <sf:select path="curator">
                <%--<sf:options itemLabel="name surname" items="${teachers}"></sf:options>--%>
                <option value="">Select the curator</option>
                <c:forEach var="teacher" items="${teachers}">
                    <sf:option value="${teacher.id}">
                        <c:out value="${teacher.name} ${teacher.surname}"></c:out>
                    </sf:option>
                </c:forEach>
            </sf:select>
        </div>
        <div class="form-group row">
            <input type="submit" class="btn btn-dark" value="Add"/>
        </div>
    </sf:form>
</div>

<div class="container text-center">
    <h3>List of Groups</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-left">
            <thead>
            <tr>
                <th>Number</th>
                <th>Curator</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="group" items="${groups}">
                <tr>
                    <td>${group.number}</td>
                    <td>${group.curator.name} ${group.curator.surname}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="templates/footer.jsp"%>