<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/login.css" />
</head>
<body>
<div class="container">
    <header class="header">
        <img class="logo" src="${pageContext.request.contextPath}/view/img/logo/office.png" alt="" />
        <h2 class="title">Management</h2>
    </header>
    <div>
        <br>
        <c:if test = "${not empty message}">
            <p class="text-danger">
                ${message}
            </p>
        </c:if>
    </div>
    <form name="login" class="form" action="login" method="post">
        <label for="username" class="label-username">
            <span class="username-span">Username</span>
            <div class="input-username-container">
                <i class="ph-envelope"></i>
                <input
                        type="text"
                        name="username"
                        id="username"
                        class="input-username"
                        placeholder="Enter your username"
                        autofocus
                        required
                />
            </div>
        </label>
        <label for="password" class="label-password">
            <span class="password-span">Password</span>

            <div class="input-password-container">
                <i class="ph-lock"></i>
                <input
                        type="password"
                        name="password"
                        id="password"
                        class="input-password"
                        placeholder="*************"
                        required
                />
            </div>
        </label>
        <a class="btn-log-in btn-continue-as-guess text-center" href="${pageContext.request.contextPath}/home">Continue as guess</a>
        <button type="submit" class="btn-log-in">Login</button>
    </form>
</div>
</body>
</html>