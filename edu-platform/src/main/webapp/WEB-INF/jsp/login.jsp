<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 04.03.18
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/login" method="post">
        <div class="form-group">
            <label for="emailInput">Email</label>
            <input type="text" class="form-control" id="emailInput"
                   placeholder="enter your email" name="email">
        </div>
        <div class="form-group">
            <label for="passwordInput">Password</label>
            <input type="password" class="form-control" id="passwordInput"
                   placeholder="enter your password" name="password">
            <a href="#">Forgot password?</a>
        </div>
        <button type="submit" class="btn btn-outline-info btn-block">Sign in</button>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
    </form>
</div>
</body>
</html>
