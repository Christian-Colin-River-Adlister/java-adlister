<%@ page import="com.codeup.comradlister.models.Country" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing a specific country"/>
    </jsp:include>

</head>
<body>
<h1>Hello Country Page</h1>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="countries" id="country-card">

</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

<script>
    const country =
<%--        <c:forEach items="${country}" var="country">--%>
        {
            id: "${country.id}",
            name: "${country.getName()}",
            continent: "${country.getContinent()}",
            level: "${country.getLevel_of_comradery()}"
        }
<%--        </c:forEach>--%>
    ;

    const parties = [
                <c:forEach items="${parties}" var="party">
        {
            name: "${party.getName()}",
            description: "${party.getDescription()}",
            dateFounded: "${party.getDateFounded()}",
            dateDissolved: "${party.getDateDissolved()}",
            flagUrl: "${party.getFlagUrl()}"
        },
            </c:forEach>];
    console.log(parties);
    const cardArea = document.getElementById("country-card");
    // const keys = Object.keys(countries);
    // for (let i = 1; i <= keys.length; i++) {
        let newCard = "";
        newCard += '<div class="card float-left border-dark-shade">\n' +
            '                    <div class="card-body bg-soft-white ">\n' +
            '                        <h4 class="card-title text-center ">' + country.name + '</h4>\n' +
            '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + country.continent + '</h6>\n' +
            '                        <h6 class="card-subtitle mb-2 text-muted text-center">1-10 How severely impacted by communism:' + country.level + '</h6>\n';
    for(let i = 0; i < parties.length; i++){
        newCard += '<h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + parties[i].name + '"> <button type="submit">' + parties[i].name + '</button></form></h4>';
        newCard += '<p class="card-text text-center text-muted">' + parties[i].description + '</p>';
        newCard += '<p class="card-text text-center text-muted">' + parties[i].dateFounded + ' - '+ parties[i].dateDissolved +'</p>';
        newCard += '<p class="card-text text-center text-muted">' + parties[i].flagUrl + '</p>';
    }
        newCard += '</div></div>';
        cardArea.innerHTML += newCard;
    // }

</script>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
