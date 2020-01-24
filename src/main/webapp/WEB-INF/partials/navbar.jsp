<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Home Page</a>
            <a class="navbar-brand" href="/comrades">Comrades</a>
            <a class="navbar-brand" href="/countries">Countries</a>
            <a class="navbar-brand" href="/parties">Parties</a>
            <a class="navbar-brand" href="/">Home Page</a>
        </div>
        <ul class="nav navbar-nav navbar-right" style="display: flex; flex-direction: row">
            <c:choose>
                <c:when test="${sessionScope.signed_in != null}">
                    <li><a href="/profile">Profile</a></li>
                    <li class="ml-2"><a href="/logout">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

