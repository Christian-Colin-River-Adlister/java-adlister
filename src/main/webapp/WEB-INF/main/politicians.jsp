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

<h1>Here Are all the Politicians!</h1>
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

    var politicians = [
        <c:forEach var="politician" items="${politicians}">
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
    var keys = Object.keys(politicians);
    if (searchTerm.value.trim() === "") {
        for (let i = 0; i < keys.length; i++) {
            let newCard = "";
            newCard += '<div style="width: 300px" class="card border-dark-shade mt-4">\n' + //style="width: 40%;"
                '                    <div class="card-body bg-soft-white ">\n' +
                '                        <h4 class="card-title text-center "><form action="/politician" method="POST"> <input type="hidden" name="name" value="' + politicians[i].name + '"> <button type="submit">' + politicians[i].name + '</button></form></h4>' +
                '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + politicians[i].description + '</h6>\n' +
                '                        <h4 class="card-title text-center ">Member of the following parties</h4>\n';
            for (let i2 = 0; i2 < politicians[i].parties.length; i2++) {
                newCard += '<h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + politicians[i].parties[i2].name + '"> <button type="submit">' + politicians[i].parties[i2].name + '</button></form>' + '</h4>\n';
                newCard += "<img <img style=\"width:250px!important;height:150px!important;\" src='" + politicians[i].parties[i2].flagUrl + "' alt='icon' class=''>";
            }
            newCard += '</div></div>';
            cardArea.innerHTML += newCard;
        }
    }

    searchTerm.addEventListener("input", function () {
        cardArea.innerHTML = '';
        for (let i = 0; i < keys.length; i++) {
            if (politicians[i].name.toLowerCase().includes(searchTerm.value.toLowerCase().trim()) || searchInParties(searchTerm.value, politicians[i].parties)) {
                let newCard = "";
                newCard += '<div style="width: 300px" class="card float-left border-dark-shade">\n';
                newCard += '                    <div class="card-body bg-soft-white ">\n' +
                    '                        <h4 class="card-title text-center "><form action="/politician" method="POST"> <input type="hidden" name="name" value="' + politicians[i].name + '"> <button type="submit">' + politicians[i].name + '</button></form></h4>' +
                    '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + politicians[i].description + '</h6>\n' +
                    '                        <h4 class="card-title text-center ">Member of the following parties</h4>\n';
                for (let i2 = 0; i2 < comrades[i].parties.length; i2++) {
                    newCard += '<h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + politicians[i].parties[i2].name + '"> <button type="submit">' + politicians[i].parties[i2].name + '</button></form>' + '</h4>\n';
                    newCard += "<img style=\"width:250px!important;height:150px!important;\" src='" + politicians[i].parties[i2].flagUrl + "' alt='icon' class='w-100'>";
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
