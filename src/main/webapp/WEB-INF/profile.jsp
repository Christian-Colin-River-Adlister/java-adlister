<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.signed_in.username}!</h1>
        <h2>${sessionScope.signed_in.getBio()}</h2>
    </div>

    <form>
        First name:<br>
        <input type="text" name="firstname" value="">
        <br>
        Last name:<br>
        <input type="text" name="lastname" value="">
        <br><br>
        <input type="submit" value="Submit">
    </form>


</body>
</html>
