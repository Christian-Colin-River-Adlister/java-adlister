<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="comrades-card-area" id="comrades-card-area">

</div>

<script>

    const comrade =
<%--        <c:forEach var="comrade" items="${comrades}">--%>
        {
            id: "${comrade.getId()}",
            name: "${comrade.getName()}",
            description: "${comrade.getDescription()}",
            userId: "${comrade.getUserId()}",
            wiki: "${comrade.getWikiLink()}",
            parties: [
                <c:forEach var="party" items="${comrade.getParties()}">
                {
                    name: "${party.getName()}",
                    description: "${party.getDescription()}",
                    dateFounded: "${party.getDateFounded()}",
                    dateDissolved: "${party.getDateDissolved()}",
                    country: "${party.getCountry()}",
                    flagUrl: "${party.getFlagUrl()}"
                },
                </c:forEach>
            ]
        };
<%--        </c:forEach>--%>
    const cardArea = document.getElementById("comrades-card-area");
    const searchTerm = document.getElementById('searchTerm');
    const keys = Object.keys(comrade);
    let newCard = "";
    newCard += '<div class="card html-editor-align-center border-dark-shade">\n' + //style="width: 40%;"
        '                    <div class="card-body bg-soft-white ">\n' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + comrade.description + '</h6>\n' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center"><a target="_blank" href="' + comrade.wiki + '">See ' + comrade.name + '\'s wiki page</a></h6>\n';
    for(let i = 0; i < comrade.parties.length; i++){
        newCard += '<h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + comrade.parties[i].name + '"> <button type="submit">' + comrade.parties[i].name + '</button></form>' + '</h4>\n';
        newCard += "<p class=\"card-text text-center\">" + comrade.parties[i].dateFounded + ' - ' + comrade.parties[i].dateDissolved + "</p>\n";
        newCard += "<p class=\"card-text text-center\">Located in: " + "<form action='/country' method='POST'><button type='submit' value='"+ comrade.parties[i].country +"'>" + comrade.parties[i].country + "</button></p></form>";
        newCard += "<img src='"+ comrade.parties[i].flagUrl +"' alt='icon' class=''>";
    }
    newCard += '</div></div>';
    cardArea.innerHTML += newCard;
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
