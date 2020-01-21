<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title></title>
    <style>

    </style>


    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the Comradlister!</h1>
    </div>

    <h2>Please log in to access tools</h2>
    <h2>Would you like to view the comrades?</h2>

<c:set var = "Supreme_Leader" scope = "session" value = "${user.getis_Supreme_Leader}"/>
<p>Your equality level is : <c:out value = "${Supreme_Leader}"/></p>
<c:choose>

    <c:when test = "${Supreme_Leader}">
        Supreme Leader is very low to survive.
    </c:when>

    <c:when test = "${Supreme_Leader}">
        Supreme Leader is very good.
    </c:when>

    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>



</body>
</html>
