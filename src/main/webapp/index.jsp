<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Home</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/homepage.css" />
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/error.css" />--%>
    <script src="${pageContext.request.contextPath}/main.js"></script>
</head>

<body>
<div class="container">
    <jsp:include page="/view/navigation.jsp"></jsp:include>
    <div class="homepage">
        <h3 class="homepage-title">Homepage</h3>
        <p class="homepage-desc">
            Chào mừng bạn đến với chương trình quản lý nhân sự phòng ban.
        </p>
        <p class="homepage-text"><strong>GVHD: </strong> Phạm Minh Tuấn</p>
        <p class="homepage-text"><strong>Thành viên: </strong></p>
        <div class="homepage-members">
            <div class="homepage-card">
                <p class="card-name"><strong>Tên: </strong> Phan Khánh Ngân</p>
                <p class="card-name"><strong>Lớp: </strong> 20T2</p>
                <p class="card-name"><strong>MSSV: </strong> 102200383</p>
            </div>
            <div class="homepage-card">
                <p class="card-name"><strong>Tên: </strong> Lê Văn Thịnh</p>
                <p class="card-name"><strong>Lớp: </strong> 20T2</p>
                <p class="card-name"><strong>MSSV: </strong> 102200391</p>
            </div>
            <div class="homepage-card">
                <p class="card-name"><strong>Tên: </strong> Nguyễn Văn Vương</p>
                <p class="card-name"><strong>Lớp: </strong> 20T2</p>
                <p class="card-name"><strong>MSSV: </strong> 102200397</p>
            </div>
        </div>
        <p class="homepage-text"><strong>Feature: </strong></p>
        <div class="homepage-feature">
            <p>1. Login</p>
            <p>2. View all employes/employee details</p>
            <p>3. Add/Update/Delete employee</p>
            <p>4. Search employee by fields</p>
            <p>5. View all departments</p>
            <p>6. Add/Update/Delete departments</p>
            <p>7. Search departments by fields</p>
            <p>8. View all slaries</p>
            <p>9. Add/Update/Delete slaries</p>
            <p>10. Search slaries by fields</p>
            <p>11. View all admins</p>
            <p>12. Add/Update/Delete admin</p>
            <p>13. Search admin by fields</p>
            <p>14. Logout</p>
        </div>
    </div>
</div>
</div>
</body>
</html>


