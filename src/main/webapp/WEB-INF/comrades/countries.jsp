<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: colinmarchbanks
  Date: 1/21/20
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<h1>Here are all the Countries comrade!</h1>

<c:forEach var="country" items="${countries}">
    <div class="comrade">
        <h2 class="country-name">${country.getName()}</h2>
        <p class="comrade-bio">On the continent of ${country.getContinent()}</p>
        <p class="comrade-bio">Level ${country.getLevel_of_comradery()} communist state</p>
    </div>
</c:forEach>
</div>
</body>
</html>
