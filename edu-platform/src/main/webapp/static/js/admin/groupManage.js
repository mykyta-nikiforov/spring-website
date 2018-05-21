// Get groupId from url path
var url = window.location.href;
var result = url.match(/groups-manage\/group-\d+/);
var groupId = parseInt(result[0].match(/\d+/));

$(document).ready(function () {
    // Events of the button to update the course
    $('#edit-group-button').click(function () {
        if(!$('#edit-group-number').val() || !$('#edit-group-curator').val()) {
            $('#edit-group-input-warning').show("slow");
        } else {
            $('#edit-group-input-warning').hide();
            $.ajax({
                url: '/admin/update-group',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    groupId: groupId,
                    number: $('#edit-group-number').val(),
                    curatorId: $('#edit-group-curator').val()
                }),
                success: function(group) {
                    $('#edit-group-number').val(group.number);
                    $('#edit-group-input-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("bad from `$('#edit-group-button').click(function ()`");
                }
            });
        }
    });

    // Event for deleting of student
    $('.remove-student-button').click(function () {
        var id = $(this).attr('student-id');
        makeRemoveStudentButton(id);
    })

    $('#delete-group-button').click(function() {
        $.ajax({
            url: '/admin/delete-group?id=' + groupId,
            type: 'DELETE',
            dataType: 'text',
            success: function () {
                window.location = '/admin/groups-manage';
            },
            error: function() {
                alert("BAD");
            }
        });
    })
});

function makeRemoveStudentButton(id) {
    $.ajax({
        url: '/admin/delete-student?id=' + id,
        type: 'DELETE',
        success: function() {
            $('[student-id=\'' + id + '\']').parentsUntil('tbody').remove();
        },
        error: function() {
            alert('bad from makeRemoveStudentButton()');
        }
    });
}