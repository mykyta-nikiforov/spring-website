// Get courseId from url path
var url = window.location.href;
var courseId = parseInt(url.match(/courses-manage\/\d+/)[0].match(/\d+/));

// Get lectureId from url path
var lectureId = parseInt(url.match(/edit-lecture\/\d+/)[0].match(/\d+/));

$(document).ready(function () {

    // Events of the button to update the lecture
    $('#update-lecture-button').click(function () {
        if ($('#update-lecture-name').val() == '') {
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

                    $('#update-lecture-input-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("badfrom `update-lecture-button`.click");
                }
            });
        }
    });

    // Event of the button to add new lecture file
    $('#add-file-button').click(function() {
        if($('#add-file-desc').val() == '' || $('#add-file-file')[0].files.length == 0){
            $('#add-file-input-warning').show("slow");
        } else {
            $('#add-file-input-warning').hide();
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
                    // Append new file to the table of files
                    $('#files-table').find('tbody').append('<tr>\n' +
                        '                    <td>' + lectureFile.id + '</td>\n' +
                        '                    <td><a href="/lecture-file?id=' + lectureFile.id + '" target="_blank">' + lectureFile.fileName + '</a></td>\n' +
                        '                    <td>' + lectureFile.description + '</td>\n' +
                        '                    <td>' + lectureFile.contentType + '</td>\n' +
                        '                    <td><button lecture-file-id=\'' + lectureFile.id + '\' class="remove-lecture-file-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                    </tr>');

                    // Set event on delete button
                    var newElement = $('[lecture-file-id=\'' + lectureFile.id + '\']');
                    newElement.click(function () {
                        makeRemoveLectureFileButton(lectureFile.id, newElement);
                    });

                    // Reset form inputs
                    $('#add-file-form')[0].reset();

                    // If PDF, add it to <select> of the main lecture's PDF
                    if(lectureFile.contentType == 'application/pdf'){
                        $('#select-pdf-file').append('<option value="' + lectureFile.id + '">' + lectureFile.fileName + '</option>');
                    }

                    // successful alert
                    $('#add-file-input-updated').show("slow").delay(600).fadeOut();
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
            $('#select-pdf-file-warning').show("slow");
        } else {
            $('#select-pdf-file-warning').hide();
            $.ajax({
                url: '/add-lecture-pdf',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    lectureFileId: $('#select-pdf-file').val(),
                    lectureId: lectureId
                }),
                success: function (pdfFile) {
                    $('#select-pdf-file-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("bad from `add-pdf-button`.click");
                }
            });
        }
    });

    // Event for removing of lecture file
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
            if($('#select-pdf-file').empty()) {
                $('#select-pdf-file').append('<option value="">Choose the file</option>');
            }
        },
        error: function () {
            alert("bad from makeRemoveLectureFileButton()");
        }
    });
}