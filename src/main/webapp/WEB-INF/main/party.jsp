<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing specific party" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="parties-card-area" id="parties-card-area">

</div>

<script>

    const party = {
            name: "${party.getName()}",
            description: "${party.getDescription()}",
            dateFounded: "${party.getDateFounded()}",
            dateDissolved: "${party.getDateDissolved()}",
            countryID: "${party.getCountryID()}",
            flagUrl: "${party.getFlagUrl()}"
        };
    var politicians = [
        <c:forEach var="politician" items="${politicians}">
        {
            name: "${politician.getName()}",
            description: "${politician.getDescription()}",
            userId: "${politician.getUserId()}",
            wikiLink: "${politician.getWikiLink()}"
        },
        </c:forEach>
    ];
    console.log(politicians)
    const cardArea = document.getElementById("parties-card-area");
    const searchTerm = document.getElementById('searchTerm');
    let newCard = "";
    newCard += '<div class="card float-left border-dark-shade">' +
        '                    <div class="card-body bg-soft-white ">' +
        '                        <h4 class="card-title text-center ">' + party.name + '</h4>' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + party.description + '</h6>\n' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + party.dateFounded + ' - ' + party.dateDissolved + '</h6>' +
        '                        <img class="mx-auto" style=\'width: 300px!important;height: 150px!important;\' src="'+ party.flagUrl +'" alt="">' +
        '                        <h4 class="card-title text-center ">Associated Members</h4>';
    for(let i = 0; i < politicians.length; i++){
        newCard += '<h4 class="card-title text-center "><form action="/politician" method="POST"> <input type="hidden" name="name" value="' + politicians[i].name + '"> <button type="submit">' + politicians[i].name + '</button></form></h4>';
        newCard += '<p class="card-text text-center text-muted">' + politicians[i].description + '</p>';
    }
    newCard += '</div></div>';
    cardArea.innerHTML += newCard;
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
