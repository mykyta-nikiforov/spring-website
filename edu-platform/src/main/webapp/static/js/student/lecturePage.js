$(document).ready(function () {

    var req = new XMLHttpRequest();

    req.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var blob = req.response;
            $('#pdf-container').attr('src', window.URL.createObjectURL(blob));

        }
    };

    req.open("GET", "/displayPDF?id=18", true);
    req.responseType = "blob";
    req.send();
});
