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
                    countryID: "${party.getCountryID()}",
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
            newCard += '<div class="card float-left border-dark-shade">\n' + //style="width: 40%;"
                '                    <div class="card-body bg-soft-white ">\n' +
                '                        <h4 class="card-title text-center "><a target="_blank" href="' + comrade.wiki + '">' + comrade.name + '</a></h4>\n' +
                '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + comrade.description + '</h6>\n';
            for(let i2 = 0; i < comrade.parties.length; i++){
                newCard += "<p class=\"card-text text-center\">" + comrade.parties[i].dateFounded + ' - ' + comrade.parties[i].dateDissolved + "</p>\n";
                newCard += "<img src='"+ comrade.parties[i].flagUrl +"' alt='icon' class=''>";
                newCard += '<p class="card-text text-center text-muted">' + comrade.parties[i].name + '</p>';
            }
            newCard += '</div></div>';
            cardArea.innerHTML += newCard;
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
