<%@page pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">${lecture.name}</h1>
        <p>${lecture.description}</p>
    </div>
</div>

<p>CONTENT</p>

<%@include file="templates/footer.jsp"%>