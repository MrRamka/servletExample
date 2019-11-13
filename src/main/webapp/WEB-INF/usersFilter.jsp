<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Filter</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:forEach var="user" items="${users}">
        <p>${user.toString()}</p>
    </c:forEach>

    <%--<form class="form" method="POST" action="/users">--%>
        <%--<label>Sort by</label>--%>
        <%--<div class="form-group">--%>
            <%--<div class="form-group">--%>
                <%--<label for="user_country_select">Country select</label>--%>
                <%--<select class="form-control" id="user_country_select" name="user_country_select">--%>
                    <%--<option>Russia</option>--%>
                    <%--<option>Spain</option>--%>
                    <%--<option>Turkey</option>--%>
                    <%--<option>Finland</option>--%>
                    <%--<option>Any</option>--%>
                <%--</select>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label for="user_sex_select">Country select</label>--%>
                <%--<select class="form-control" id="user_sex_select" name="user_sex_select">--%>
                    <%--<option>Male</option>--%>
                    <%--<option>Female</option>--%>
                    <%--<option>Any</option>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<button type="submit" class="btn btn-primary">Sort</button>--%>
    <%--</form>--%>

    <form class="form" method="POST" action="/users">
        <label>Sort by</label>
        <div class="form-group">
            <div class="form-group">
                <label for="user_sort_select">Country select</label>
                <select class="form-control" id="user_sort_select" name="user_sort_select">
                    <option>Country</option>
                    <option>Sex</option>
                </select>
            </div>

        </div>
        <button type="submit" class="btn btn-primary">Sort</button>
    </form>
    <p>Sorted by: ${sortingMethod}</p>

</div>
</body>
</html>
