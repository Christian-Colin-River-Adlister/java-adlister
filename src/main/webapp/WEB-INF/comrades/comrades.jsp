<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the comrades!</h1>

    <c:forEach var="comrade" items="${comrades}">
        <div class="comrade">
            <div>
                <button class="delete">X</button>
                <button class="edit">E</button>
            </div>
            <div>
                <h2 class="comrade-name">${comrade.getName()}</h2>
                <p class="comrade-bio">${comrade.getDescription()}</p>
            </div>
            <div class="comrade-parties">
                <c:forEach var="party" items="${comrade.getParties()}">
                    <div>
                        <img src="${party.getUrl()}" alt="logo" class="party-icon">
                        <h6 class="comrade-party-name">${party.getName()}</h6>
                    </div>
                </c:forEach>
            </div>
            <div>
                <p>Post by <a href="">tempUserName69</a></p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
