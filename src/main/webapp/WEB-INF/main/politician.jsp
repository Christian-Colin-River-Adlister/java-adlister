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
<div class="politicians-card-area" id="politicians-card-area">

</div>

<script>

    const politician =
        {
            id: "${politician.getId()}",
            name: "${politician.getName()}",
            description: "${politician.getDescription()}",
            userId: "${politician.getUserId()}",
            wiki: "${politician.getWikiLink()}",
            headShot: "${politician.getHead_shot_url()}",
            parties: [
                <c:forEach var="party" items="${politician.getParties()}">
                {
                    name: "${party.getName()}",
                    description: "${party.getDescription()}",
                    wikiLink: "${party.getWiki_link()}",
                    country: "${party.getCountry()}",
                    flagUrl: "${party.getFlagUrl()}"
                },
                </c:forEach>
            ]
        };
    const cardArea = document.getElementById("politicians-card-area");
    const searchTerm = document.getElementById('searchTerm');
    const keys = Object.keys(politician);
    let newCard = "";
    newCard += '<div class="card html-editor-align-center border-dark-shade">\n' +
        '                    <div class="card-body bg-soft-white ">' +
        '                        <h4 class="card-subtitle mb-2 text-muted text-center">' + politician.name + '</h4>' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + politician.description + '</h6>\n' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center"><a target="_blank" href="' + politician.wiki + '">See ' + politician.name + '\'s wiki page</a></h6>\n';
    for(let i = 0; i < politician.parties.length; i++){
        newCard += '<h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + politician.parties[i].name + '"> <button type="submit">' + politician.parties[i].name + '</button></form>' + '</h4>\n';
        newCard += "<p class=\"card-text text-center\">Located in: " + "<form action='/country' method='POST'><input type='hidden' name='name' value='"+ politician.parties[i].country +"'><button type='submit' value='"+ politician.parties[i].country +"'>" + politician.parties[i].country + "</button></p></form>";
        newCard += "<img style='width: 300px!important;height: 150px!important;' src='"+ politician.parties[i].flagUrl +"' alt='icon' class=''>";
    }
    newCard += '</div></div>';
    cardArea.innerHTML += newCard;
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
