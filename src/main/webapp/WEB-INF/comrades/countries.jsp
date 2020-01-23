<%@ page import="com.codeup.comradlister.models.Country" %>
<%@ page import="java.util.List" %>
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
    <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Viewing All The countries"/>
</jsp:include>
</head>
<body>
<h1>Here are all the Countries affected by wonderful communism comrade!</h1>

<div class="card border-0 w-100" style="width: 18rem;">
    <div class="input-group border-0">
        <input type="text" class="form-control border-0 bg-soft-white no-radius-top" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default" id="searchTerm" placeholder="Enter search term">
    </div>
</div>

<%
    List<Country> countries = (List<Country>) session.getAttribute("countries");
%>

<div id="country-card-area">
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>

<script>
    var countries = {
        <c:forEach items="${countries}" var="country">
        "${country.id}": {
            id: "${country.id}",
            name: "${country.getName()}",
            continent: "${country.getContinent()}",
            level: "${country.getLevel_of_comradery()}"
        },
        </c:forEach>
    };
    const cardArea = document.getElementById("country-card-area");
    const searchTerm = document.getElementById('searchTerm');
    var keys = Object.keys(countries);
    if (searchTerm.value.trim() === "") {
        for (let i = 0; i < keys.length; i++) {
            cardArea.innerHTML += '<div class="card float-left mx-3 mb-2  border-dark-shade" style="width: 40%;">\n' +
                '                    <div class="card-body bg-soft-white ">\n' +
                '                        <h4 class="card-title text-center "><form action="/country" method="POST"> <input type="hidden" name="name" value="' + countries[i+1].name + '"> <button type="submit">' + countries[i+1].name + '</button></form>' + '</h4>\n' +
                '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + countries[i + 1].continent + '</h6>\n' +
                '                        <p class="card-text text-center">' + countries[i + 1].level + '</p>\n' +
                '                </div>'
        }

    }
    searchTerm.addEventListener("input", function () {
        cardArea.innerHTML = '';
        for (let i = 0; i < keys.length; i++) {
            if (countries[i + 1].name.toLowerCase().includes(searchTerm.value.toLowerCase().trim()) || countries[i + 1].continent.toLowerCase().includes(searchTerm.value.toLowerCase().trim()) || countries[i + 1].level === searchTerm.value) {
                cardArea.innerHTML += '<div class="card float-left mx-3 mb-2  border-dark-shade" style="width: 40%;">\n' +
                    '                    <div class="card-body bg-soft-white ">\n' +
                    '                        <h4 class="card-title text-center "><form action="/country" method="POST"> <input type="hidden" name="name" value="' + countries[i+1].name + '"> <button type="submit">' + countries[i+1].name + '</button></form>' + '</h4>\n' +
                    '                        <h6 class="card-subtitle mb-2 text-muted text-center">' + countries[i + 1].continent + '</h6>\n' +
                    '                        <p class="card-text text-center">' + countries[i + 1].level + '</p>\n' +
                    '                </div>'
            }
        }
    });
</script>


</body>
</html>
