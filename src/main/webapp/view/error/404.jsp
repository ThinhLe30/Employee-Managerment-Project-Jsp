<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/24/2022
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>404 Error</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&family=Varela+Round&display=swap"
            rel="stylesheet"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/index.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/error.css" />
    <script src="${pageContext.request.contextPath}/main.js"></script>
</head>

<body>
<div class="container">
    <jsp:include page="/view/navigation.jsp"></jsp:include>
    <div class="error">
        <div class="error-info">
            <span>404 error </span>
            <h2>The request page cannot be found.</h2>
            <h3>An error has occurred while processing your request.</h3>
            <h4>You may not be able to visit this page because of:</h4>
            <ul>
                <li>an <strong>out-of-date bookmark/favourite.</strong></li>
                <li>a <strong>mistyped address.</strong></li>
                <li>you have <strong>no access</strong> to this page (login to continue).</li>
            </ul>
            <a class="error-btn-homepage" href="${pageContext.request.contextPath}/home">Home page</a>
        </div>
        <div class="error-img">
            <img src="${pageContext.request.contextPath}/view/img/error/404error.svg" />
        </div>
    </div>
</div>
</body>
</html>
