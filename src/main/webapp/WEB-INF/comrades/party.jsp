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
    <%--        </c:forEach>--%>
    const cardArea = document.getElementById("comrades-card-area");
    const searchTerm = document.getElementById('searchTerm');
    let newCard = "";
    newCard += '<div class="card float-left border-dark-shade">' +
        '                    <div class="card-body bg-soft-white ">' +
        '                        <h4 class="card-title text-center ">' + party.name + '</h4>' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + party.description + '</h6>\n' +
        '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + party.dateFounded + ' - ' + party.dateDissolved + '</h6>';
    newCard += '</div></div>';
    cardArea.innerHTML += newCard;
</script>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
