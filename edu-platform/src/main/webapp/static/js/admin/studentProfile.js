var url = window.location.href;
var studentId = parseInt(url.match(/students\/\d+/)[0].match(/\d+/));

$(document).ready(function() {
    // make empty password input
    $('#update-password-input').val('');

    $('#update-student-button').click(function () {
        if(!$('#update-student-email').val() || !$('#update-student-surname').val()
            || !$('#update-student-name') || !$('#update-student-patronymic').val()
            || !$('#update-student-group').val()){
            $('#update-student-warning').show("slow");
        } else {
            $('#update-student-warning').hide();
            $.ajax({
                url: '/admin/update-student',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: studentId,
                    email: $('#update-student-email').val(),
                    surname: $('#update-student-surname').val(),
                    name: $('#update-student-name').val(),
                    patronymic: $('#update-student-patronymic').val(),
                    groupId: $('#update-student-group').val()
                }),
                success: function(student) {
                    $('#update-student-email').val(student.email);
                    $('#update-student-surname').val(student.surname);
                    $('#update-student-name').val(student.name);
                    $('#update-student-patronymic').val(student.patronymic);
                    $('#update-student-group').val(student.group.id);

                    $('#update-student-success').show("slow").delay(600).fadeOut();
                },
                error: function(){
                    alert("bad from AJAX to /admin/update-student")
                }
            });
        }

    });

    $('#update-password-button').click(function() {
        if(!$('#update-password-input').val()) {
            $('#update-password-warning').show("slow");
        } else {
            $('#update-password-warning').hide();
            $.ajax({
                url: '/admin/update-student-password',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: studentId,
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

    $('#delete-student-button').click(function() {
        $.ajax({
            url: '/admin/delete-student?id=' + studentId,
            type: 'DELETE',
            dataType: 'text',
            success: function () {
                window.location = '/admin/users-manage/students';
            },
            error: function() {
                alert("BAD");
            }
        });
    })
})