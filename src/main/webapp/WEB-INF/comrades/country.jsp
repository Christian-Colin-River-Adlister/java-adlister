<%@ page import="com.codeup.comradlister.models.Country" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing a specific country"/>
    </jsp:include>

</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="countries" id="Individual-country">

</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

<script>
    var countries = [
        <c:forEach items="${countries}" var="country">
        {
            id: "${country.id}",
            name: "${country.getName()}",
            continent: "${country.getContinent()}",
            level: "${country.getLevel_of_comradery()}"
        },
        </c:forEach>
    ];
    const card = document.getElementsByID("country-card");
    for (let i = 1; i < keys.length; i++) {
        let newCard = "";
        newCard += '<div class="card float-left border-dark-shade">\n' +
            '                    <div class="card-body bg-soft-white ">\n' +
            '                        <h4 class="card-title text-center "><a href="' + countries[i].wiki + '">' + countries[i].name + '</h4>\n' +
            '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + countries[i].description + '</h6>\n';
        newCard += '</div></div>';
        cardArea.innerHTML += newCard;
    }

</script>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
