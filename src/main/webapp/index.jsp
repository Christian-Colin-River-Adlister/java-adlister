<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>



    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 id="welcome">Welcome to the Comradlister!</h1>
    </div>

    <div>
        <img src="images/ussr-flag.jpg" alt="HTML5 Icon" id="flag" width="300" height="400">
    </div>

    <h2><a href="/login" id="login">Please log in to access tools.</a></h2>
    <h2><a href="/register" id="register">Click here to register your account.</a></h2>
    <h2><a href="/comrades" id="comrades">Would you like to view the comrades?</a></h2>



</body>
</html>
