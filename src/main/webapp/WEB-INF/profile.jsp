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

    <h2>Please enter your info here!</h2>
    <form id="userform">
        Name: <input type="text" name="username">
    <br>
    <h2>Enter a description here!</h2>
    <textarea rows="4" cols="50" name="comment" form="userform">
    </textarea>
        <input type="submit">
    </form>




</body>
</html>
