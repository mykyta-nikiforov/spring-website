// Get courseId from url path
var url = window.location.href;
var courseId = parseInt(url.match(/courses-manage\/\d+/)[0].match(/\d+/));

// Get labWorkId from url path
var labWorkId = parseInt(url.match(/edit-labwork\/\d+/)[0].match(/\d+/));
console.log("hi");
$(document).ready(function () {
    // Events of the button to update the labwork
    $('#update-labwork-button').click(function () {
        if ($('#update-labwork-name').val() == ''
            && $('#update-labwork-desc').val() == ''
            && $('#update-labwork-deadline').val() == '') {
            $('#update-labwork-input-warning').css("visibility", "visible")
                .animate({opacity: 1.0}, 500);
            // alert("Input values!")
        } else {
            $('#update-labwork-input-warning').css("visibility", "hidden");
            $.ajax({
                url: '/update-labwork',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    id: labWorkId,
                    name: $('#update-labwork-name').val(),
                    description: $('#update-labwork-desc').val(),
                    deadLine: $('#update-labwork-deadline').val(),
                    courseId: courseId
                }),
                success: function (labwork) {
                    $('#update-labwork-name').val(labwork.name);
                    $('#update-labwork-desc').val(labwork.description);
                    $('#update-labwork-deadline').val(labwork.deadLine);

                    $('#update-labwork-input-updated').css({
                        visibility: "visible",
                        opacity: 1.0
                    }).animate({opacity: 0.0}, 3000);
                },
                error: function () {
                    alert("badfrom `update-labwork-button`.click");
                }
            });
        }
    });

});