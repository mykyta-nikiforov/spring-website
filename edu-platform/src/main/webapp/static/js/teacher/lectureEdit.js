// Get courseId from url path
var url = window.location.href;
var courseId = parseInt(url.match(/courses-manage\/\d+/)[0].match(/\d+/));

// Get lectureId from url path
var lectureId = parseInt(url.match(/edit-lecture\/\d+/)[0].match(/\d+/));

$(document).ready(function () {
    // Events of the button to update the course
    $('#update-lecture-button').click(function () {
        if ($('#update-lecture-name').val() == '') {
            $('#update-lecture-input-warning').css("visibility", "visible")
                .animate({opacity: 1.0}, 500);
            // alert("Input values!")
        } else {
            $('#update-lecture-input-warning').css("visibility", "hidden");
            $.ajax({
                url: '/update-lecture',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: lectureId,
                    name: $('#update-lecture-name').val(),
                    courseId: courseId
                }),
                success: function (lecture) {
                    $('#update-lecture-name').val(lecture.name);

                    $('#update-lecture-input-updated').css({
                        visibility: "visible",
                        opacity: 1.0
                    }).animate({opacity: 0.0}, 3000);
                },
                error: function () {
                    alert("badfrom `update-lecture-button`.click");
                }
            });
        }
    })
});
