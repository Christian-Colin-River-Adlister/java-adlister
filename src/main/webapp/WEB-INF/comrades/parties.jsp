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

<div class="card border-0 w-100" style="width: 18rem;">
    <div class="input-group border-0">
        <input type="text" class="form-control border-0 bg-soft-white no-radius-top" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default" id="searchTerm" placeholder="Enter search term">
    </div>
</div>
<div class="comrades-card-area" id="comrades-card-area">
    <h1>Here Are all the parties!</h1>

</div>

<script>
    var parties = [
        <c:forEach var="party" items="${parties}">
        {
            name: "${party.getName()}",
            description: "${party.getDescription()}",
            dateFounded: "${party.getDateFounded()}",
            dateDissolved: "${party.getDateDissolved()}",
            countryID: "${party.getCountryID()}",
            flagUrl: "${party.getFlagUrl()}"
        },
        </c:forEach>
    ];

    const cardArea = document.getElementById("comrades-card-area");
    const searchTerm = document.getElementById('searchTerm');
    var keys = Object.keys(parties);
    if (searchTerm.value.trim() === "") {
        for (let i = 0; i < keys.length; i++) {
            let newCard = "";
            newCard += '<div class="card float-left border-dark-shade">\n' + //style="width: 40%;"
                '                    <div class="card-body bg-soft-white ">\n' +
                '                        <h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + parties[i].name + '"> <button type="submit">' + parties[i].name + '</button></form></h4>' +
                '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + parties[i].description + '</h6>\n';
            newCard += '</div></div>';
            cardArea.innerHTML += newCard;
        }
    }

    searchTerm.addEventListener("input", function () {
        cardArea.innerHTML = '';

        for (let i = 0; i < keys.length; i++) {
            if (parties[i].name.toLowerCase().includes(searchTerm.value.toLowerCase().trim()) || parties[i].countryID == ) {
                let newCard = "";
                newCard += '<div class="card float-left border-dark-shade">\n' + //style="width: 40%;"
                    '                    <div class="card-body bg-soft-white ">\n' +
                    '                        <h4 class="card-title text-center "><form action="/party" method="POST"> <input type="hidden" name="name" value="' + parties[i].name + '"> <button type="submit">' + parties[i].name + '</button></form></h4>' +
                    '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + parties[i].description + '</h6>\n';
                newCard += '</div></div>';
                cardArea.innerHTML += newCard;
            }
        }
    });
</script>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
