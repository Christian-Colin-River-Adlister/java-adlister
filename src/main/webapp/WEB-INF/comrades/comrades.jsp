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

<div class="comrades-card-area">
    <h1>Here Are all the comrades!</h1>

<%--    <c:forEach var="comrade" items="${comrades}">--%>
<%--        <div class="comrade">--%>
<%--            <div>--%>
<%--                <button class="delete">X</button>--%>
<%--                <button class="edit">E</button>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <h2 class="comrade-name">${comrade.getName()}</h2>--%>
<%--                <p class="comrade-bio">${comrade.getDescription()}</p>--%>
<%--            </div>--%>
<%--            <div class="comrade-parties">--%>
<%--                <c:forEach var="party" items="${comrade.getParties()}">--%>
<%--                    <div>--%>
<%--                        <img src="${party.getUrl()}" alt="logo" class="party-icon">--%>
<%--                        <h6 class="comrade-party-name">${party.getName()}</h6>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <p>Post by <a href="">tempUserName69</a></p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
</div>


<script>
    var comrades = {
        <c:forEach var="comrade" items="${comrades}">
        "${comrade.getId()}": {
            id: "${comrade.getId()}",
            name: "${comrade.getName()}",
            description: "${comrade.getDescription()}",
            userId: "${comrade.getUser_id()}",
            parties: [
                <c:forEach var="party" items="${comrade.getParties()}">
                {
                    id: "${party.getId()}",
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
    };
    const cardArea = document.getElementById("comrades-card-area");
    const searchTerm = document.getElementById('searchTerm');
    var keys = Object.keys(comrades);
    if (searchTerm.value.trim() === "") {
        for (let i = 0; i < keys.length; i++) {
                cardArea.innerHTML += '<div class="card float-left mx-3 mb-2  border-dark-shade" style="width: 40%;">\n' +
                    '                    <div class="card-body bg-soft-white ">\n' +
                    '                        <h4 class="card-title text-center ">' + comrades[i + 1].name + '</h4>\n' +
                    '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + comrades[i + 1].description + '</h6>\n' +
                    '                        <p class="card-text text-center">' + comrades[i + 1].dateFounded + ' - ' + comrades[i + 1].dateDissolved + '</p>\n';
                for(let i2 = 0; i2 < comrades[i + 1].parties.length; i2++){
                    cardArea.innerHTML += "<img src='"+ comrades[i + 1].parties[i2].flagUrl +"' alt='icon' class=''>";
                    cardArea.innerHTML += '<p class="card-text text-center text-muted">' + comrades[i + 1].parties[i2].name + '</p>';
                }
                cardArea.innerHTML += '</div></div>';
        }
    }
    searchTerm.addEventListener("input", function () {
        cardArea.innerHTML = '';
        for (let i = 0; i < keys.length; i++) {
            if (comrades[i + 1].name.toLowerCase().includes(searchTerm.value.toLowerCase().trim())) {
                cardArea.innerHTML += '<div class="card float-left mx-3 mb-2  border-dark-shade" style="width: 40%;">\n' +
                    '                    <div class="card-body bg-soft-white ">\n' +
                    '                        <h4 class="card-title text-center ">' + comrades[i + 1].name + '</h4>\n' +
                    '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + comrades[i + 1].description + '</h6>\n' +
                    '                        <p class="card-text text-center">' + comrades[i + 1].dateFounded + ' - ' + comrades[i + 1].dateDissolved + '</p>\n';
                for(let i2 = 0; i2 < comrades[i + 1].parties.length; i2++){
                    cardArea.innerHTML += "<img src='"+ comrades[i + 1].parties[i2].flagUrl +"' alt='icon' class=''>";
                    cardArea.innerHTML += '<p class="card-text text-center text-muted">' + comrades[i + 1].parties[i2].name + '</p>';
                }
                cardArea.innerHTML += '</div></div>';
            }
        }
    });
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
