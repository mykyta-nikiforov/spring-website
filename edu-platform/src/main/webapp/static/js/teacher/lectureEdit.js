// Get courseId from url path
var url = window.location.href;
var courseId = parseInt(url.match(/courses-manage\/\d+/)[0].match(/\d+/));

// Get lectureId from url path
var lectureId = parseInt(url.match(/edit-lecture\/\d+/)[0].match(/\d+/));

$(document).ready(function () {

    // Initialize all popovers
    $('#add-pdf-button').popover({
        trigger: 'focus'
    });
    $('#add-file-button').popover({
        trigger: 'focus'
    });


    // Events of the button to update the lecture
    $('#update-lecture-button').click(function () {
        if ($('#update-lecture-name').val() == '') {
            $('#update-lecture-input-updated').hide();
            $('#update-lecture-input-warning').show("slow");
        } else {
            $('#update-lecture-input-warning').hide();
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

                    $('#update-lecture-input-updated').show("slow").delay(4000).fadeOut();
                },
                error: function () {
                    alert("badfrom `update-lecture-button`.click");
                }
            });
        }
    });

    // Events of the button to add new lecture file
    $('#add-file-button').click(function() {
        if($('#add-file-desc').val() == '' || $('#add-file-file')[0].files.length == 0){
            // $('#add-file-input-warning').css("visibility", "visible");
            $('#add-file-button').popover('show');
        } else {
            $('#add-file-button').popover('hide');
            $('#add-file-input-warning').css("visibility", "hidden");
            // Variable to store the file itself and JSON of its fileInfo
            var formData = new FormData();
            var lectureFileInfo = {
                description: $('#add-file-desc').val(),
                lectureId: lectureId
            };
            formData.append("lectureFileInfo", new Blob(
                [JSON.stringify(lectureFileInfo)],
                {type: "application/json"}));
            formData.append("file", $('#add-file-file').prop('files')[0]);

            $.ajax({
                url: '/add-lecture-file',
                type: 'POST',
                contentType: false,
                processData: false,
                data: formData,
                success: function (lectureFile) {
                    $('#files-table').find('tbody').append('<tr>\n' +
                        '                    <td>' + lectureFile.id + '</td>\n' +
                        '                    <td><a href="/displayLecture?id=' + lectureFile.id + '" target="_blank">' + lectureFile.fileName + '</a></td>\n' +
                        '                    <td>' + lectureFile.description + '</td>\n' +
                        '                    <td>' + lectureFile.contentType + '</td>\n' +
                        '                    <td><button lecture-file-id=\'' + lectureFile.id + '\' class="remove-lecture-file-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                    </tr>');

                    var newElement = $('[lecture-file-id=\'' + lectureFile.id + '\']');
                    newElement.click(function () {
                        makeRemoveLectureFileButton(lectureFile.id, newElement);
                    });
                    $('#add-file-form')[0].reset();
                    $('#select-pdf-file').append('<option value="' + lectureFile.id + '">' + lectureFile.fileName + '</option>');
                },
                error: function () {
                    alert("bad from `add-lecture-button`.click");
                }
            });
        }
    });

    // Events of the button to select LecturePDFFile
    $('#add-pdf-button').click(function () {
        if ($('#select-pdf-file').val() == '') {
            // $('#update-lecture-input-warning').css("visibility", "visible")
            //     .animate({opacity: 1.0}, 500);
            $('#add-pdf-button').popover('show');
            // alert("Input values!")
        } else {
            // $('#update-lecture-input-warning').css("visibility", "hidden");
            $.ajax({
                url: '/add-lecture-pdf',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    lectureFileId: $('#select-pdf-file').val(),
                    lectureId: lectureId,
                }),
                success: function (pdfFile) {
                    console.log(pdfFile);
                    // $('#update-lecture-name').val(lecture.name);
                    //
                    // $('#update-lecture-input-updated').css({
                    //     visibility: "visible",
                    //     opacity: 1.0
                    // }).animate({opacity: 0.0}, 3000);
                    alert("success!");
                },
                error: function () {
                    alert("bad from `add-pdf-button`.click");
                }
            });
        }
    });

    $('.remove-lecture-file-button').click(function() {
        var button = $(this);
        var id = $(this).attr('lecture-file-id');
        makeRemoveLectureFileButton(id, button);
    })
});

function makeRemoveLectureFileButton(id, element) {
    $.ajax({
        url: '/delete-lecture-file/' + id,
        type: 'DELETE',
        success: function () {
            element.parentsUntil('tbody').remove();
            $('#select-pdf-file').find('[value="' + id + '"]').remove();
        },
        error: function () {
            alert("bad from makeRemoveLectureFileButton()");
        }
    });
}