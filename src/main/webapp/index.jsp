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
        <h1 id="welcome">Welcome to the Politic Lister!</h1>
    </div>

    <div>
    </div>

    <h2><a href="/login" id="login">Please log in to access tools.</a></h2>
    <h2><a href="/register" id="register">Click here to register your account.</a></h2>
    <h2><a href="/comrades" id="comrades">Would you like to view the politicians?</a></h2>



</body>
</html>
