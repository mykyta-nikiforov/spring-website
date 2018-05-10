$(document).ready(function() {
    $('#add-teacher-button').click(function() {
        if(!$('#add-teacher-email').val() || !$('#add-teacher-password').val()
            || !$('#add-teacher-surname').val()  || !$('#add-teacher-name').val()
            || !$('#add-teacher-patronymic').val()  || !$('#add-teacher-degree').val()){
            $('#add-teacher-warning').show('slow');
            console.log(!$('#add-teacher-email').val());
            console.log(!$('#add-teacher-password').val());
            console.log(!$('#add-teacher-surname').val());
            console.log(!$('#add-teacher-name').val());
            console.log(!$('#add-teacher-patronymic').val());
            console.log(!$('#add-teacher-degree').val());
        } else{
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
                    $('#teachers-table').find('tbody').append('<tr>\n' +
                        '                    <td><a href="/admin/users-manage/teachers/' + teacher.id + '">' + teacher.surname + teacher.name + teacher.patronymic + '</a></td>\n' +
                        '                    <td>' + teacher.email + '</td>\n' +
                        '                    <td>' + teacher.degree.name + '</td>\n' +
                        '                    <td><a href="/admin/users-manage/teachers/delete-teacher?id=' + teacher.id + '"><span class="oi oi-trash"></span></a></td>\n' +
                        '                </tr>');
                    $('#add-teacher-added').show("slow").delay(600).fadeOut();
                    $('#add-teacher-form')[0].reset();
                }
            });
        }

    })
})