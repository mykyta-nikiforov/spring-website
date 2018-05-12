$(document).ready(function () {
    console.log("hi!");
    $('#add-student-button').click(function () {
        if (!$('#add-student-email').val() || !$('#add-student-password').val()
            || !$('#add-student-name').val() || !$('#add-student-surname').val()
            || !$('#add-student-patronymic').val() || !$('#add-student-group').val()) {
            $('#add-student-warning').show("slow");
        } else {
            $('#add-student-warning').hide();
            $.ajax({
                url: '/admin/add-student',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    email: $('#add-student-email').val(),
                    password: $('#add-student-password').val(),
                    name: $('#add-student-name').val(),
                    surname: $('#add-student-surname').val(),
                    patronymic: $('#add-student-patronymic').val(),
                    groupId: $('#add-student-group').val()
                }),
                success: function (student) {
                    $('#add-student-success').show("slow").delay(600).fadeOut();
                    $('#students-table').find('tbody').append(`<tr>\n` +
                        `                    <td>${student.email}</td>\n` +
                        `                    <td><a href="/admin/users-manage/students/${student.id}">${student.surname} ${student.name} ${student.patronymic}</a></td>\n` +
                        `                    <td>${student.group.number}</td>\n` +
                        `                    <td>\n` +
                        `                        <button student-id="${student.id}" class="remove-button btn btn-outline-danger">\n` +
                        `                            <span>\n` +
                        `                                <i class="oi oi-trash"></i>\n` +
                        `                            </span>\n` +
                        `                        </button>\n` +
                        `                    </td>\n` +
                        `                </tr>`);

                    var deleteButton = $(`[student-id='${student.id}']`);
                    console.log(deleteButton);
                    deleteButton.click(function () {
                        removeStudent(deleteButton);
                    });

                    $('#add-student-form')[0].reset();
                },
                error: function () {
                    alert("bad from AJAX `/admin/add-student`")
                }
            });

        }

    });

    $('.remove-button').click(function () {
        var button = $(this);
        removeStudent(button);
    })
});

function removeStudent(button){
    var id = button.attr('student-id');
    $.ajax({
        url: '/admin/delete-student?id=' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function() {
            button.parentsUntil('tbody').remove();
        },
        error: function() {
            alert('bad from `removeStudent`')
        }
    });
}