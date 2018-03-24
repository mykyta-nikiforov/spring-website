$(document).ready(function() {
    $('#add-lecture-button').click(function() {
        if($('#lecture-name').val() == ''){
            $('#add-lecture-input-warning').css("display", "inline");
            // alert("Input values!")
        } else {
            $('#add-lecture-input-warning').css("display", "none");
            $.ajax({
                url: '/add-lecture',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    name: $('#lecture-name').val(),
                    courseId: courseId
                }),
                success: function (lecture) {
                    $('#lectures-table').find('tbody').append('<tr>\n' +
                        '                    <td>' + lecture.id + '</td>\n' +
                        '                    <td><a href="/edit-lecture/' + lecture.id + '">' + lecture.name + '</a></td>\n' +
                        '                    <td><button lecture-id=\'' + lecture.id + '\' class="remove-button"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                </tr>');

                    var newElement = $('[lecture-id=\'' + lecture.id + '\']');
                    newElement.click(function () {
                        makeRemoveButton(lecture.id, newElement);
                    });
                    $('#new-lecture-form')[0].reset();
                    console.log(lecture);
                },
                error: function () {
                    alert("bad");
                }
            });
        }
    });


    $('.remove-button').click(function () {
        var button = $(this);
        var id = $(this).attr("lecture-id");
        console.log(id);
        console.log("from initial remove-button func")
        makeRemoveButton(id, button);
    });
});

function makeRemoveButton(id, element) {
    $.ajax({
        url: '/delete-lecture/' + id,
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

// Get courseId from url path
var url = window.location.href;
var result = url.match(/courses-manage\/\d+/);
var courseId = parseInt(result[0].match(/\d+/));