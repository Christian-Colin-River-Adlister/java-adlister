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
        <h1>Welcome to the Comradlister!</h1>
    </div>

    <h2><a href="/login">Please log in to access tools.</a></h2>
    <h2><a href="/register">Click here to register your account.</a></h2>
    <h2><a href="/comrades">Would you like to view the comrades?</a></h2>



</body>
</html>
