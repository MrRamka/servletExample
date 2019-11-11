<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Check email</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form class="form" method="POST" action="/email">
        <div class="form-group">
            <label for="user_email">Email address</label>
            <input type="text" class="form-control" id="user_email" name="user_email"
                   aria-describedby="emailHelp" placeholder="Enter email" required>
        </div>
        <button type="submit" class="btn btn-primary">Check</button>
    </form>
    <c:if test="${!status.isEmpty()}">
        <c:if test="${status == 'true'}">
            <p class="text-success">Your email is correct</p>
        </c:if>
        <c:if test="${status == 'false'}">
            <p class="text-danger">Your email is incorrect</p>
        </c:if>
    </c:if>

</div>
</body>
</html>
