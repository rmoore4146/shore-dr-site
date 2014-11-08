<!DOCTYPE html>
<html lang="en">

<%--Include page <head> element & additional page-specific javascript--%>
<%@include file="decorator/commonHeadElement.jsp"%>
<%--<script type="text/javascript" src="${contextPath}/site/javascript/wedding.js"></script>--%>

<body>

<div id="wrap">

    <%--Include header--%>
    <%@include file="decorator/header.jsp"%>

    <%--Body goes here--%>
    <div class="container bodyContainer">
        <div class="jumbotron">
            <h2>Some heading...</h2>
            <p>Blah blah blah</p>
        </div>
    </div>
</div>

<%--Include Footer--%>
<%@include file="decorator/footer.jsp"%>
</body>
</html>
