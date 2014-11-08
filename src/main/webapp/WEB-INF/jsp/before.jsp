<!DOCTYPE html>
<html lang="en">

<%--Include page <head> element & additional page-specific javascript--%>
<%@include file="decorator/commonHeadElement.jsp"%>
<script type="text/javascript" src="${contextPath}/site/javascript/sliderCommon.js"></script>

<body>

<div id="wrap">

    <%--Include header--%>
    <%@include file="decorator/header.jsp"%>

    <%--Body goes here--%>
    <div class="container bodyContainer">
        <div class="jumbotron">
            <h2>Before the storm...</h2>
            <div class="slider">
                <c:forEach items="${photos}" var="photo">
                    <div>
                        <div class="center-block">
                            <img src="${photo.url}" class="img-responsive center-block"/>
                            <h2><span>${photo.title}</span></h2>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>

<%--Include Footer--%>
<%@include file="decorator/footer.jsp"%>
</body>
</html>
