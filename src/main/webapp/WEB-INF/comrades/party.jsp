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

    const party = {
            name: "${party.getName()}",
            description: "${party.getDescription()}",
            dateFounded: "${party.getDateFounded()}",
            dateDissolved: "${party.getDateDissolved()}",
            countryID: "${party.getCountryID()}",
            flagUrl: "${party.getFlagUrl()}"
        };
    var comrades = [
        <c:forEach var="comrad" items="${comrads}">
        {
            name: "${comrad.getName()}",
            description: "${comrad.getDescription()}",
            userId: "${comrad.getUserId()}",
            wikiLink: "${comrad.getWikiLink()}"
        },
        </c:forEach>
    ];
    console.log(comrades)
    const cardArea = document.getElementById("comrades-card-area");
    const searchTerm = document.getElementById('searchTerm');
    let newCard = "";
    newCard += '<div class="card float-left border-dark-shade">' +
        '                    <div class="card-body bg-soft-white ">' +
        '                        <h4 class="card-title text-center ">' + party.name + '</h4>' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + party.description + '</h6>\n' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + party.dateFounded + ' - ' + party.dateDissolved + '</h6>' +
        '                        <img class="mx-auto" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6GyZatX6eM0wvRzxSz2tqOyyKia8HuIRSf5RRTbmnAcHB9gr9&s" alt="">' +
        '                        <h4 class="card-title text-center ">Associated Members</h4>';
    for(let i = 0; i < comrades.length; i++){
        newCard += '<h4 class="card-title text-center "><form action="/comrade" method="POST"> <input type="hidden" name="name" value="' + comrades[i].name + '"> <button type="submit">' + comrades[i].name + '</button></form></h4>';
        newCard += '<p class="card-text text-center text-muted">' + comrades[i].description + '</p>';
    }
    newCard += '</div></div>';
    cardArea.innerHTML += newCard;
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
