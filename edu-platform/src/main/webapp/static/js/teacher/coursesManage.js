console.log("hello");

$(document).ready(function() {
    $('#add-course-button').click(function() {
        if(!$('#course-name').val() || !$('#course-desc').val()){
            $('#add-course-input-warning').show("slow");
        } else {
            $('#add-course-input-warning').hide();
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
                        '                    <td><button course-id=\'' + course.id + '\' class="remove-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                </tr>');

                    var newElement = $('[course-id=\'' + course.id + '\']');
                    newElement.click(function () {
                        makeRemoveButton(course.id, newElement);
                    });
                    $('#new-course-form')[0].reset();

                    $('#add-course-input-added').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("bad");
                }
            });
        }
    });


    $('.remove-button').click(function () {
        var button = $(this);
        var id = $(this).attr("course-id");
        makeRemoveButton(id, button);
    });
});

function makeRemoveButton(id, element) {
    console.log("from function removeStudent(), " + id + ", " + element)
    $.ajax({
        url: '/delete-course?id=' + id,
        type: 'DELETE',
        datatype: 'text',
        success: function () {
            element.parentsUntil('tbody').remove();
        },
        error: function () {
            alert("bad");
        }

    });
}