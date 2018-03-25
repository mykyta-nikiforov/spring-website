<%@page pageEncoding="UTF-8" %>
<%@include file="../templates/header.jsp"%>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">${lecture.name}</h1>
    </div>
</div>
<%--<iframe src="/displayLecture?id=3" width="400px" height="300px"></iframe>--%>
<%--<object data="/displayLecture?id=3" type="application/pdf" width="400px" height="300px"></object>--%>
<div>
    <embed src="" type="application/pdf" width="900px" height="500px"></embed>
</div>
<%--</object>--%>
<div class="container">
    <embed id="pdf-container" width="900px" height="500px" name="plugin" src="" type="application/pdf">
</div>


<%--<object data="/displayLecture?id=3" type="application/pdf" width="750px" height="750px">--%>
    <%--<embed src="/displayLecture?id=3" type="application/pdf">--%>
        <%--<p>This browser does not support PDFs. Please download the PDF to view it: <a href="/displayImage?id=3">Download PDF</a>.</p>--%>
    <%--</embed>--%>
<%--</object>--%>

<%--<object data="/displayLecture?id=3" type="application/pdf" height="100%" width="100%">--%>
    <%--<iframe src="/displayLecture?id=3" style="border: none;" height="100%" width="100%">--%>
        <%--This browser does not support PDFs. Please download the PDF to view it: <a href="/displayImage?id=3">Download PDF</a>--%>
    <%--</iframe>--%>
<%--</object>--%>



<%--<div id="example1"></div>--%>

<%--<script src="/static/js/pdfobject.js"></script>--%>
<%--<script>PDFObject.embed("/displayImage?id=3", "#example1");</script>--%>

<script src="../../../static/js/pdfobject.js"></script>
<script src="../../../static/js/student/lecturePage.js"></script>
<%@include file="../templates/footer.jsp"%>