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
                        '                    <td><button lecture-id=\'' + lecture.id + '\' class="remove-lecture-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                </tr>');

                    var newElement = $('[lecture-id=\'' + lecture.id + '\']');
                    newElement.click(function () {
                        makeRemoveLectureButton(lecture.id, newElement);
                    });
                    $('#new-lecture-form')[0].reset();
                    console.log(lecture);
                },
                error: function () {
                    alert("badfrom `add-lecture-button`.click");
                }
            });
        }
    });

    $('#add-labwork-button').click(function() {
        if($('#labwork-name').val() == '' || $('#labwork-desc').val() == ''
            || $('#labwork-deadline').val() == ''){
            $('#add-labwork-input-warning').css("display", "inline");
            // alert("Input values!")
        } else {
            $('#add-labwork-input-warning').css("display", "none");
            $.ajax({
                url: '/add-labwork',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    name: $('#labwork-name').val(),
                    description: $('#labwork-desc').val(),
                    deadLine: $('#labwork-deadline').val(),
                    courseId: courseId
                }),
                success: function (labwork) {
                    $('#labworks-table').find('tbody').append('<tr>\n' +
                        '                    <td>' + labwork.id + '</td>\n' +
                        '                    <td><a href="/edit-labwork/' + labwork.id + '">' + labwork.name + '</a></td>\n' +
                        '                    <td><button labwork-id=\'' + labwork.id + '\' class="remove-labwork-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                </tr>');

                    var newElement = $('[labwork-id=\'' + labwork.id + '\']');
                    newElement.click(function () {
                        makeRemoveLabworkButton(labwork.id, newElement);
                    });
                    $('#new-labwork-form')[0].reset();
                    console.log(labwork);
                },
                error: function () {
                    alert("badfrom `add-labwork-button`.click");
                }
            });
        }
    });


    $('.remove-lecture-button').click(function () {
        var button = $(this);
        var id = $(this).attr("lecture-id");
        console.log(id);
        console.log("from initial remove-lecture-button func")
        makeRemoveLectureButton(id, button);
    });

    $('.remove-labwork-button').click(function () {
        var button = $(this);
        var id = $(this).attr("labwork-id");
        console.log(id);
        console.log("from initial remove-labwork-button func");
        makeRemoveLabworkButton(id, button);
    });
});

function makeRemoveLectureButton(id, element) {
    $.ajax({
        url: '/delete-lecture/' + id,
        type: 'DELETE',
        datatype: 'text',
        success: function () {
            element.parentsUntil('tbody').remove();
        },
        error: function () {
            alert("bad from makeRemoveLectureButton()");
        }

    });
}

function makeRemoveLabworkButton(id, element) {
    $.ajax({
        url: '/delete-labwork/' + id,
        type: 'DELETE',
        datatype: 'text',
        success: function() {
            element.parentsUntil('tbody').remove();
        },
        error: function () {
            alert("bad from makeRemoveLabworkButton()")

        }
    });

}

// Get courseId from url path
var url = window.location.href;
var result = url.match(/courses-manage\/\d+/);
var courseId = parseInt(result[0].match(/\d+/));