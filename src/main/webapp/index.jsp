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

<c:set var = "Supreme_Leader" scope = "session" value = "${user.getis_Supreme_Leader}"/>
<p>Your salary is : <c:out value = "${}"/></p>
<c:choose>

    <c:when test = "${Supreme_Leader <= 0}">
        Supreme Leader is very low to survive.
    </c:when>

    <c:when test = "${Supreme_Leader > 1000}">
        Supreme Leader is very good.
    </c:when>

    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>

    <form>
        First name:
        <input type="text" name="firstname">

        Last name:
        <input type="text" name="lastname">

        <input type="submit" value="Submit">
    </form>

</body>
</html>
