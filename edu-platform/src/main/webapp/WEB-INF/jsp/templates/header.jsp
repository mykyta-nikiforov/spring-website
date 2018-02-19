<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div role="navigation">
    <nav class="navbar navbar-dark bg-dark">
        <a href="#" class="navbar-brand" >Edu-platform</a>
        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link text-light" href="allCourses">All courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="course-manage">Manage</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="#">Schedule</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="#">Schedule</a>
            </li>
        </ul>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
</div>