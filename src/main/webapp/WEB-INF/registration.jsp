<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-lg-6 col-md-6 col-sm-12">
        <form class="form" method="POST" action="/registration">
            <div class="form-group">
                <label for="user_name">Name</label>
                <input type="text" class="form-control" id="user_name" name="user_name"
                       aria-describedby="nameHelp" placeholder="Enter name" required>
            </div>
            <div class="form-group">
                <label for="user_email">Email address</label>
                <input type="email" class="form-control" id="user_email" name="user_email"
                       aria-describedby="emailHelp" placeholder="Enter email" required>
            </div>
            <div class="form-group">
                <label for="user_pass">Password</label>
                <input type="password" class="form-control" id="user_pass" name="user_pass"
                       placeholder="Password" required>
            </div>
            <div class="form-group">
                <label for="conf_user_pass">Confirm password</label>
                <input type="password" class="form-control" id="conf_user_pass" name="conf_user_pass"
                       placeholder="Confirm password" required>
            </div>
            <div class="form-group">
                <label for="user_country_select">Country select</label>
                <select class="form-control" id="user_country_select" name="user_country_select">
                    <option>Russia</option>
                    <option>Spain</option>
                    <option>Turkey</option>
                    <option>Finland</option>
                </select>
            </div>
            <div class="form-group">

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="m">
                    <label class="form-check-label" for="inlineRadio1">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="f">
                    <label class="form-check-label" for="inlineRadio2">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label for="about_user">About me</label>
                <input type="text" class="form-control" id="about_user" name="about_user"
                       aria-describedby="nameHelp" placeholder="About me" required>
            </div>
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="data_processing" name="data_processing">
                <label class="custom-control-label" for="data_processing">Consent for data processing</label>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
        <c:if test="${!status.isEmpty()}">
            <c:if test="${status == 'true'}">
                <p class="text-success">User created successfully</p>
            </c:if>
            <c:if test="${status == 'false'}">
                <p class="text-danger">Cant create user</p>
            </c:if>
        </c:if>
    </div>
</div>

</body>
</html>
