$(document).ready(function () {

    // Events of the Save button
    $('#update-settings-button').click(function () {
        if (!$('#update-settings-email').val() || !$('#update-settings-password').val()
            || !$('#update-settings-name').val() || !$('#update-settings-surname').val()
            || !$('#update-settings-patronymic').val()) {
            $('#update-settings-input-warning').show("slow");
        } else {
            $('#update-settings-input-warning').hide();
            $.ajax({
                url: '/save-settings',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    email: $('#update-settings-email').val(),
                    password: $('#update-settings-password').val(),
                    name: $('#update-settings-name').val(),
                    surname: $('#update-settings-surname').val(),
                    patronymic: $('#update-settings-patronymic').val(),
                }),
                success: function () {
                    alert("SUCCESS");
                },
                error: function () {
                    alert("ERROR");
                }
            });
        }
    })
});