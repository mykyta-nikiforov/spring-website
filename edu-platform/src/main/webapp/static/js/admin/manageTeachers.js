$(document).ready(function () {

    $('#add-teacher-button').click(function () {
        if (!$('#add-teacher-email').val() || !$('#add-teacher-password').val()
            || !$('#add-teacher-surname').val() || !$('#add-teacher-name').val()
            || !$('#add-teacher-patronymic').val() || !$('#add-teacher-degree').val()) {
            $('#add-teacher-warning').show('slow');
        } else {
            $('#add-teacher-warning').hide();
            $.ajax({
                url: '/admin/add-teacher',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    email: $('#add-teacher-email').val(),
                    password: $('#add-teacher-password').val(),
                    name: $('#add-teacher-name').val(),
                    surname: $('#add-teacher-surname').val(),
                    patronymic: $('#add-teacher-patronymic').val(),
                    degreeId: $('#add-teacher-degree').val()
                }),
                success: function (teacher) {
                    $('#add-teacher-added').show("slow").delay(600).fadeOut();
                    $('#teachers-table').find('tbody').append('<tr>\n' +
                        '                    <td><a href="/admin/users-manage/teachers/' + teacher.id + '">' + teacher.surname + teacher.name + teacher.patronymic + '</a></td>\n' +
                        '                    <td>' + teacher.email + '</td>\n' +
                        '                    <td>' + teacher.degree.name + '</td>\n' +
                        '                    <td><button teacher-id=\"' + teacher.id + '\" class="remove-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                </tr>');

                    var deleteButton = $('[teacher-id=\'' + teacher.id + '\']');
                    deleteButton.click(function() {
                        removeTeacher(deleteButton);
                    })
                    $('#add-teacher-form')[0].reset();
                }
            });
        }

    });

    $('.remove-button').click(function () {
        var button = $(this);
        removeTeacher(button);
    });
});

function removeTeacher(button) {
    var id = button.attr("teacher-id");
    $.ajax({
        url: '/admin/delete-teacher?id=' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            button.parentsUntil('tbody').remove();
        },
        error: function() {
            alert("bad!");
        }
    });
}