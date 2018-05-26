<%@page pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>
<script src="/static/js/user/userSettings.js"></script>

<div class="container">

    <h3>Update settings</h3>

    <form id="update-settings-form">
        <div class="form-group row">
            <label class="col-form-label col-md-3">Email</label>
            <div class="col-md-5">
                <input type="text" id="update-settings-email" class="form-control" value="${principal.email}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Password</label>
            <div class="col-md-5">
                <input type="text" id="update-settings-password" class="form-control" value="${principal.password}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Name</label>
            <div class="col-md-5">
                <input type="text" id="update-settings-name" class="form-control" value="${principal.name}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Surname</label>
            <div class="col-md-5">
                <input type="text" id="update-settings-surname" class="form-control" value="${principal.surname}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-form-label col-md-3">Patronymic</label>
            <div class="col-md-5">
                <input type="text" id="update-settings-patronymic" class="form-control" value="${principal.patronymic}"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-3">
                <input type="button" id="update-settings-button" class="btn btn-dark" value="Save"/>
            </div>
            <div id="update-settings-input-warning" class="alert alert-warning alert-hide col-md-4" role="alert">
                Cannot be empty!
            </div>
            <div id="update-settings-input-updated" class="alert alert-success alert-hide col-md-4" role="alert">
                Successfully updated.
            </div>
        </div>
    </form>
</div>

<%@include file="templates/footer.jsp"%>