console.log("hello");

$(document).ready(function() {
    $('#add-course-button').click(function() {
        $.ajax({
            url: '/add-course2',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                name: $('#course-name').val(),
                description: $('#course-desc').val()
            }),
            success: function (course) {
                $('#courses-table').find('tbody').append('<tr>\n' +
                    '                    <td>' + course.id + '</td>\n' +
                    '                    <td><a href="/courses-manage/' + course.id + '">' + course.name + '</a></td>\n' +
                    '                    <td>' + course.description + '</td>\n' +
                    '                    <td><a href="/delete-course?id=' + course.id + '"><span class="oi oi-trash"></span></a></td>\n' +
                    '                </tr>');
                $('#course-name').cleanData();
                $('#course-desc').cleanData();

            },
            error: function () {
                alert: "bad";
            }
        });
    });
})