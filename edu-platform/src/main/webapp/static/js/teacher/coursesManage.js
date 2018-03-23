console.log("hello");

$(document).ready(function() {
    $('#add-course-button').click(function() {
        $.ajax({
            url: 'add-course',
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
                    '                    <td><a href="#" course-id=\'' + course.id + '\' class="remove-button"><span><i class="oi oi-trash"></i></span></a></td>\n' +
                    '                </tr>');

                var newElement = $('[course-id=\'' + course.id + '\']');
                newElement.click(function () {
                    makeRemoveButton(course.id, newElement);
                });
            },
            error: function () {
                alert("bad");
            }
        });
    });


    $('.remove-button').click(function () {
        var button = $(this);
        var id = $(this).attr("course-id");
        console.log(id);
        makeRemoveButton(id, button);
    });
});

function makeRemoveButton(id, element) {
    $.ajax({
        url: 'delete-course?id=' + id,
        type: 'DELETE',
        success: function () {
            element.parentsUntil('tbody').remove();
        },
        error: function () {
            alert("bad");
        }

    });
}