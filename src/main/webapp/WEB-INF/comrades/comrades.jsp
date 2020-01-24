<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="card border-0 w-100" style="width: 18rem;">
    <div class="input-group border-0">
        <input type="text" class="form-control border-0 bg-soft-white no-radius-top" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default" id="searchTerm" placeholder="Enter search term">
    </div>
</div>

<h1>Here Are all the comrades!</h1>
<div class="container d-flex justify-content-around flex-wrap" id="comrades-card-area">

</div>


<script>

    function searchInParties(string, array) {
        let bool = false;
        for (let i = 0; i < array.length; i++) {
            if (array[i].name.toLowerCase().includes(string.toString().toLowerCase().trim())) {
                bool = true;
            }
        }
        return bool;
    }

    var comrades = [
        <c:forEach var="comrade" items="${comrades}">
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
                    countryID: "${party.getCountryID()}",
                    flagUrl: "${party.getFlagUrl()}"
                },
                </c:forEach>
            ]
        },
        </c:forEach>
    ];
    const cardArea = document.getElementById("comrades-card-area");
    const searchTerm = document.getElementById('searchTerm');
    var keys = Object.keys(comrades);
    if (searchTerm.value.trim() === "") {
        for (let i = 0; i < keys.length; i++) {
            let newCard = "";
            newCard += '<div style="width: 300px" class="card border-dark-shade mt-4">\n' + //style="width: 40%;"
                '                    <div class="card-body bg-soft-white ">\n' +
                '                        <h4 class="card-title text-center "><form action="/comrade" method="POST"> <input type="hidden" name="name" value="' + comrades[i].name + '"> <button type="submit">' + comrades[i].name + '</button></form></h4>' +
                '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + comrades[i].description + '</h6>\n';
            for (let i2 = 0; i2 < comrades[i].parties.length; i2++) {
                newCard += "<p class=\"card-text text-center\">" + comrades[i].parties[i2].dateFounded + ' - ' + comrades[i].parties[i2].dateDissolved + "</p>\n";
                newCard += "<img src='" + comrades[i].parties[i2].flagUrl + "' alt='icon' class=''>";
                newCard += '<p class="card-text text-center text-muted">' + comrades[i].parties[i2].name + '</p>';
            }
            newCard += '</div></div>';
            cardArea.innerHTML += newCard;
        }
    }

    searchTerm.addEventListener("input", function () {
        cardArea.innerHTML = '';
        for (let i = 0; i < keys.length; i++) {
            if (comrades[i].name.toLowerCase().includes(searchTerm.value.toLowerCase().trim()) || searchInParties(searchTerm.value, comrades[i].parties)) {
                let newCard = "";
                newCard += '<div style="width: 300px" class="card float-left border-dark-shade">\n';
                newCard += '                    <div class="card-body bg-soft-white ">\n' +
                    '                        <h4 class="card-title text-center ">' + comrades[i].name + '</h4>\n' +
                    '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + comrades[i].description + '</h6>\n';
                for (let i2 = 0; i2 < comrades[i].parties.length; i2++) {
                    newCard += "<p class=\"card-text text-center\">" + comrades[i].parties[i2].dateFounded + ' - ' + comrades[i].parties[i2].dateDissolved + "</p>\n";
                    newCard += "<img src='" + comrades[i].parties[i2].flagUrl + "' alt='icon' class=''>";
                    newCard += '<p class="card-text text-center text-muted">' + comrades[i].parties[i2].name + '</p>';
                }
                newCard += '</div></div>';
                cardArea.innerHTML += newCard;
            }
        }
    });
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
