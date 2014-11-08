<!DOCTYPE html>
<html lang="en">

<%--Include page <head> element & additional page-specific javascript--%>
<%@include file="decorator/commonHeadElement.jsp"%>

<body>

<div id="wrap">

    <input id="mobileFlag" value="${isMobile}" style="display: none;">
    <script type="text/javascript" src="${contextPath}/site/javascript/sliderCommon.js"></script>

    <%--Include header--%>
    <%@include file="decorator/header.jsp"%>

    <%--Body goes here--%>
    <div class="container bodyContainer">
        <div class="jumbotron">
            <h2>Before the storm...</h2>
            <div class="slider-nav">
                <c:forEach items="${photos}" var="photo">
                    <div>
                        <h1><img src="${photo.urlSmall}"/></h1>
                    </div>
                </c:forEach>
            </div>
            <div class="slider">
                <c:forEach items="${photos}" var="photo">
                    <div>
                        <div class="center-block">
                            <img src="${photo.url}" class="img-responsive center-block"/>
                            <h2 style="display: inline-block;"><span>${photo.title}</span></h2>
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
