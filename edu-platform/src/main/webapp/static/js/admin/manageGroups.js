$(document).ready(function () {
    $('#add-group-button').click(function () {
        if(!$('#add-group-number').val() || !$('#add-group-specialty').val()
            || !$('#add-group-curator').val()){
            $('#add-group-warning').show("slow");
        } else {
            $('#add-group-warning').hide();
            $.ajax({
                url: '/admin/add-group',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    number: $('#add-group-number').val(),
                    specialtyId: $('#add-group-specialty').val(),
                    yearOfStudy: 1,
                    curatorId: $('#add-group-curator').val()
                }),
                success: function(group) {
                    // Add group to the table
                    $('#groups-table').find('tbody').append(`<tr>
                        <td>
                            <a href="/admin/groups-manage/group-${group.id}">
                                ${group.number}
                            </a>
                        </td>
                        <td><a href="/admin/users-manage/teachers/${group.curator.id}">${group.curator.surname} ${group.curator.name} ${group.curator.patronymic}</a></td>
                        <td>
                            <button group-id="${group.id}" class="remove-button btn btn-outline-danger">
                                <span><i class="oi oi-trash"></i></span>
                            </button>
                        </td>
                    </tr>`);

                    $('#add-group-success').show("slow").delay(600).fadeOut();

                    $('#add-group-form')[0].reset();
                },
                error: function () {
                    alert("bad from AJAX to '/admin/add-group'");
                }
            });
        }
    });
});