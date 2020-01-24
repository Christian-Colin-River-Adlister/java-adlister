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

<div class="container">

    <div class="row">
        <div class="col-6">
            <div class="card">
                <h2 class="mx-auto text-center">Would you like to enter a new comrade?</h2>
                <form id="comradeform" action="/comrades/create" method="post" class="w-75 mx-auto">
                    <input class = "w-100 text-center mt-3" type="text" name="name" placeholder="Full name">
                    <br>
                    <textarea class="text-center mt-3 w-100" rows="4" cols="50" name="description" placeholder="Description here"></textarea><br>
                    <input class="w-100 text-center mt-3"type="text" name="wiki_link" placeholder="Wikipedia link for the associated comrade"><br>
                    <div class="mt-3 w-100">
                        <select name="parties" id="parties" class="w-100">
                            <c:forEach var="party" items="${sessionScope.parties}">
                                <option class="parties w-100" value="${party.name}">${party.name}</option>
                            </c:forEach>
                        </select>
                        <button class="mt-3 w-100" type="button" id="partyButton">Add Party</button>
                    </div>
                    <br>
                    <input type="hidden" name="partyArea" id="partyArea"/>
                    <input class="w-100" type="submit">
                    <br>
                </form>
            </div>
        </div>

        <c:choose>
            <c:when test="${sessionScope.signed_in.is_Supreme_leader}">
                <div class="col-6">
                    <div class="card d-flex justify-content-center">
                        <h2 class="text-center">Admins can add parties, enter information below</h2>
                        <form id="partyform" action="/comrades/create/party" method="post" class="mx-auto w-75">
                            <input class="w-100 text-center mt-3" type="text" name="name" placeholder="Name of the party">
                            <br>
                            <textarea class="text-center w-100 mt-3" rows="4" cols="50" name="description" placeholder="Description here"></textarea><br>
                            <input class="w-100 text-center  mt-3" type="text" name="date_founded" placeholder="Date Founded">
                            <input class="w-100 text-center  mt-3" type="text" name="date_dissolved" placeholder="Date Dissolved"><br>
                            <select class="w-100 mt-3 text-center d-flex justify-content-center" name="country" id="country">
                                <c:forEach var="country" items="${sessionScope.countries}">
                                    <option class="w-100" value="${country.id}">${country.name}</option>
                                </c:forEach>
                            </select>
                            <input class="w-100 text-center  mt-3" type="text" name="flag_url" placeholder="Url of the flag"><br>
                            <input type="submit" class=" mt-3 w-100">
                            <br>
                        </form>
                    </div>
                </div>
            </c:when>
        </c:choose>


    </div>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
<script>
    document.getElementById("partyButton").addEventListener("click", function () {
        if (!document.getElementById("partyArea").value.includes($("#parties").val())) {
            document.getElementById("partyArea").value += "" + $("#parties").val() + ",";
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
