// Get courseId from url path
var url = window.location.href;
var result = url.match(/courses-manage\/\d+/);
var courseId = parseInt(result[0].match(/\d+/));

// $('#edit-course-desc').val("hello");
// console.log($('#edit-course-desc').val());


$(document).ready(function() {
    // Events of the button to update the course
    $('#edit-course-button').click(function() {
        if($('#edit-course-name').val() == '' || $('#edit-course-desc').val == ''){
            $('#edit-course-input-warning').css("visibility", "visible")
                .animate({opacity: 1.0}, 500);
            // alert("Input values!")
        } else {
            $('#edit-course-input-warning').css("visibility", "hidden");
            $.ajax({
                url: '/update-course',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: courseId,
                    name: $('#edit-course-name').val(),
                    description: $('#edit-course-desc').val()
                }),
                success: function (course) {
                    console.log(course.name);
                    console.log(course.description);
                    $('#edit-course-name').val(course.name);
                    $('#edit-course-desc').val(course.description);
                    $('#edit-course-input-updated').css({visibility: "visible",
                        opacity: 1.0}).animate({opacity: 0.0}, 3000);
                },
                error: function () {
                    alert("badfrom `edit-course-button`.click");
                }
            });
        }
    });

    // Events of the button to add new lecture
    $('#add-lecture-button').click(function() {
        if($('#add-lecture-name').val() == ''){
            $('#add-lecture-input-warning').css("visibility", "visible");
            // alert("Input values!")
        } else {
            $('#add-lecture-input-warning').css("visibility", "hidden");
            $.ajax({
                url: '/add-lecture',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    name: $('#add-lecture-name').val(),
                    courseId: courseId
                }),
                success: function (lecture) {
                    $('#lectures-table').find('tbody').append('<tr>\n' +
                        '                    <td>' + lecture.id + '</td>\n' +
                        '                    <td><a href="/courses-manage/' + courseId +
                        '/edit-lecture/' + lecture.id + '">' + lecture.name + '</a></td>\n' +
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

    // Events of the button to add new labwork
    $('#add-labwork-button').click(function() {
        if($('#add-labwork-name').val() == '' || $('#add-labwork-desc').val() == ''
            || $('#add-labwork-deadline').val() == ''){
            $('#add-labwork-input-warning').css("display", "inline");
            // alert("Input values!")
        } else {
            $('#add-labwork-input-warning').css("display", "none");
            $.ajax({
                url: '/add-labwork',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    name: $('#add-labwork-name').val(),
                    description: $('#add-labwork-desc').val(),
                    deadLine: $('#add-labwork-deadline').val(),
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


    // Events remove-lecture buttons
    $('.remove-lecture-button').click(function () {
        var button = $(this);
        var id = $(this).attr("lecture-id");
        console.log(id);
        console.log("from initial remove-lecture-button func")
        makeRemoveLectureButton(id, button);
    });

    // Events remove-labwork buttons
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