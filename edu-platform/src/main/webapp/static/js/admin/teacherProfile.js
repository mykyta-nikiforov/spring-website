var url = window.location.href;
var teacherId = parseInt(url.match(/teachers\/\d+/)[0].match(/\d+/));

$(document).ready(function () {
    // make empty password input
    $('#update-password-input').val('');

    $('#update-teacher-button').click(function () {
        if (!$('#update-teacher-email').val() || !$('#update-teacher-surname').val()
            || !$('#update-teacher-name') || !$('#update-teacher-patronymic').val()
            || !$('#update-teacher-degree').val()) {
            $('#update-teacher-warning').show("slow");
        } else {
            $('#update-teacher-warning').hide();
            $.ajax({
                url: '/admin/update-teacher',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: teacherId,
                    email: $('#update-teacher-email').val(),
                    surname: $('#update-teacher-surname').val(),
                    name: $('#update-teacher-name').val(),
                    patronymic: $('#update-teacher-patronymic').val(),
                    degreeId: $('#update-teacher-degree').val()
                }),
                success: function (teacher) {
                    $('#update-teacher-email').val(teacher.email);
                    $('#update-teacher-surname').val(teacher.surname);
                    $('#update-teacher-name').val(teacher.name);
                    $('#update-teacher-patronymic').val(teacher.patronymic);
                    $('#update-teacher-degree').val(teacher.degree.id);

                    $('#update-teacher-success').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("bad from `$(#update-teacher-button').click(function()`");
                }
            })
        }

    });

    $('#update-password-button').click(function() {
        if(!$('#update-password-input').val()) {
            $('#update-password-warning').show("slow");
        } else {
            $('#update-password-warning').hide();
            $.ajax({
                url: '/admin/update-teacher-password',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: teacherId,
                    password: $('#update-password-input').val()
                }),
                success: function() {
                    $('#update-password-success').show("slow").delay(600).fadeOut();
                },
                error: function() {
                    alert("bad from `$('#update-password-button').click()`");
                }
            });
        }
    });

    $('#delete-teacher-button').click(function() {
        $.ajax({
            url: '/admin/delete-teacher?id=' + teacherId,
            type: 'DELETE',
            dataType: 'text',
            success: function () {
                window.location = '/admin/users-manage/teachers';
            },
            error: function() {
                alert("BAD");
            }
        });
    })
});