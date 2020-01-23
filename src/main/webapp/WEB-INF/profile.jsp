<%@ page import="com.codeup.comradlister.models.Party" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.signed_in.username}!</h1>
    <h2>${sessionScope.signed_in.getBio()}</h2>
</div>

<h2>Would you like to enter a new comrade?</h2>
<form id="userform" action="/comrades/create" method="post">
    <input type="text" name="name" placeholder="Full name">
    <br>
    <textarea rows="4" cols="50" name="description" placeholder="Description here"></textarea>
    <input type="text" name="wiki_link" placeholder="Wikipedia link for the associated comrade">
    <select name = "parties" id = "parties">
        <c:forEach var="party" items="${sessionScope.parties}">
            <option class = "parties" value="${party.name}">${party.name}</option>
        </c:forEach>
    </select>

    <button type="button" id ="partyButton">Add Party</button>
    <input type="text" name = "partyArea" id="partyArea"/>
    <input type="submit">
    <br>
</form>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>
<script>
    document.getElementById("partyButton").addEventListener("click",function () {
        if(!document.getElementById("partyArea").value.includes($("#parties").val())){
            document.getElementById("partyArea").value += ""+$("#parties").val()+",";
        }
    });
    var parties = {
        <c:forEach items="${sessionScope.parties}" var="party">
        "${party.id}": {
            id: "${party.id}",
            name: "${party.name}",
            description: "${party.description}",
            date_founded: "${party.dateFounded}",
            date_dissolved: "${party.dateDissolved}",
            countryID: "${party.countryID}",
            flag: "${party.flagUrl}"
        },
        </c:forEach>
    };
    console.log(parties);
</script>
</body>
</html>
