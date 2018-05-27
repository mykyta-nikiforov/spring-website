$(document).ready(function () {

    // Events of the Save button
    $('#update-settings-button').click(function () {
        if (!$('#update-settings-email').val() || !$('#update-settings-name').val()
            || !$('#update-settings-surname').val() || !$('#update-settings-patronymic').val()) {
            $('#update-settings-input-warning').show("slow");
        } else {
            $('#update-settings-input-warning').hide();
            $.ajax({
                url: '/save-teacher-settings',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    email: $('#update-settings-email').val(),
                    name: $('#update-settings-name').val(),
                    surname: $('#update-settings-surname').val(),
                    patronymic: $('#update-settings-patronymic').val(),
                }),
                success: function (teacher) {
                    $('#update-settings-email').val(teacher.email);
                    $('#update-settings-surname').val(teacher.surname);
                    $('#update-settings-name').val(teacher.name);
                    $('#update-settings-patronymic').val(teacher.patronymic);

                    $('#update-settings-input-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("ERROR");
                }
            });
        }
    });

    $('#update-password-button').click(function () {
        if (!$('#update-settings-password').val()) {
            $('#update-settings-password-warning').show("slow");
        } else {
            $('#update-settings-password-warning').hide();
            $.ajax({
                url: '/save-teacher-password',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    password: $('#update-settings-password').val(),
                }),
                success: function () {
                    $('#update-password-input-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("ERROR");
                }
            });
        }
    })
});