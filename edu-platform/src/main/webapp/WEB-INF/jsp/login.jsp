<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edu-platform</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/my-login.css" rel="stylesheet">
</head>

<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Login</h4>
                        <form action="/login" method="POST">
                            <div class="form-group">
                                <label for="email">E-Mail address</label>
                                <input id="email" type="email" class="form-control"  name="email" value="" required autofocus>
                            </div>

                            <div class="form-group">
                                <label for="password">Password
                                    <a href="forgot.html" class="float-right">
                                        Forgot Password?
                                    </a>
                                </label>
                                <input id="password" type="password" class="form-control" name="password" required data-eye>
                            </div>

                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="remember"> Remember Me
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-dark btn-block">
                                    Login
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="/static/js/jquery-3.3.1.min.js"></script>
<script src="/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>