<%--
  Created by IntelliJ IDEA.
  User: christian174
  Date: 1/23/20
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing a specific country"/>
    </jsp:include>

</head>
<body>

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
        newCard += ''
    }

</script>
</body>
</html>
