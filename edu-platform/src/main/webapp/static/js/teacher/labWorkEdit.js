// Get courseId from url path
var url = window.location.href;
var courseId = parseInt(url.match(/courses-manage\/\d+/)[0].match(/\d+/));

// Get labWorkId from url path
var labWorkId = parseInt(url.match(/edit-labwork\/\d+/)[0].match(/\d+/));


$(document).ready(function () {
    // Events of the button to update the labwork
    $('#update-labwork-button').click(function () {
        if (!$('#update-labwork-name').val()
            || !$('#update-labwork-desc').val()
            || !$('#update-labwork-deadline').val()) {
            $('#update-labwork-input-warning').show("slow");
        } else {
            $('#update-labwork-input-warning').hide();
            console.log($('#update-labwork-deadline').val());
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
                    console.log(labwork.deadLine);

                    var date = new Date();
                    date.setDate(labwork.deadLine.dayOfMonth);
                    date.setMonth(labwork.deadLine.monthValue-1);
                    date.setYear(labwork.deadLine.year);

                    console.log(date);
                    $('#update-labwork-deadline').valueAsDate = date;

                    $('#update-labwork-input-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("badfrom `update-labwork-button`.click");
                }
            });
        }
    });

    // Event of the button to add new labwork file
    $('#add-file-button').click(function () {
        if (!$('#add-file-desc').val() || $('#add-file-file')[0].files.length == 0) {
            $('#add-file-input-warning').show("slow");
        } else {
            $('#add-file-input-warning').hide();
            // Variable to store the file itself and JSON of its fileInfo
            var formData = new FormData();
            var labWorkFileInfo = {
                description: $('#add-file-desc').val(),
                labWorkId: labWorkId
            };
            formData.append("labWorkFileInfo", new Blob(
                [JSON.stringify(labWorkFileInfo)],
                {type: "application/json"}));
            formData.append("file", $('#add-file-file').prop('files')[0]);

            $.ajax({
                url: '/add-labwork-file',
                type: 'POST',
                contentType: false,
                processData: false,
                data: formData,
                success: function (labWorkFile) {
                    // // Append new file to the table of all files
                    $('#files-table').find('tbody').append('<tr>\n' +
                        '                    <td>' + labWorkFile.id + '</td>\n' +
                        '                    <td>' + labWorkFile.fileName + '</td>\n' +
                        '                    <td>' + labWorkFile.description + '</td>\n' +
                        '                    <td>' + labWorkFile.contentType + '</td>\n' +
                        '                    <td><button labwork-file-id=\'' + labWorkFile.id + '\' class="remove-labwork-file-button btn btn-outline-danger"><span><i class="oi oi-trash"></i></span></button></td>\n' +
                        '                    </tr>');
                    var newElement = $('[labwork-file-id=\'' + labWorkFile.id + '\']');
                    newElement.click(function () {
                        makeRemoveLabWorkFileButton(labWorkFile.id);
                    });

                    // Reset inputs
                    $('#add-file-form')[0].reset();

                    $('#add-file-input-updated').show("slow").delay(600).fadeOut();
                },
                error: function () {
                    alert("bad from `add-file-button`.click");
                }
            });
        }
    });

    $('.remove-labwork-file-button').click(function () {
        var id = $(this).attr('labwork-file-id');
        makeRemoveLabWorkFileButton(id);
    });

});

function makeRemoveLabWorkFileButton(id) {
    $.ajax({
        url: '/delete-labwork-file/' + id,
        type: 'DELETE',
        success: function() {
            $('[labwork-file-id=\'' + id + '\']').parentsUntil('tbody').remove();
        },
        error: function() {
            alert('bad from makeRemoveLabWorkFileButton()');
        }
    });

}