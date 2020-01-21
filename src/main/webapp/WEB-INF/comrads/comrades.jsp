<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <jsp:include page="/WEB-INF/partials/head.jsp">--%>
<%--        <jsp:param name="title" value="Viewing All The Ads" />--%>
<%--    </jsp:include>--%>
</head>
<body>
<%--<jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="comrade" items="${comrades}">
        <div class="comrade">
            <h2 class="comrade-name">${comrade.getName()}</h2>
            <p class="comrade-bio">${comrade.getBio()}</p>
            <div class="comrade-parties">
                <c:forEach var="party" items="${comrade.getParties()}">
                    <div>
                        <img src="${party.getUrl()}" alt="logo" class="party-icon">
                        <h6 class="comrade-party-name">${party.getName()}</h6>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
