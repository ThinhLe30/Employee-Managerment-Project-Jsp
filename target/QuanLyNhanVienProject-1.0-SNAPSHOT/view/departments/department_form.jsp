<%@ page import="com.ngthvu.quanlynhanvienproject.bean.EmployeeView" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.bean.Salary" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${pageTitle}</title>
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
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/index.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/form.css" />
    <script src="${pageContext.request.contextPath}/main.js"></script>
</head>

<body>
<div class="container">
    <jsp:include page="/view/navigation.jsp"></jsp:include>
    <div class="container_form">
        <br><br>
        <div>
            <h2 class="text-center">${pageTitle}</h2>
        </div>
        <form name="department_form" class="form"
              method="post" action="${pageContext.request.contextPath}/department/save"
              style="max-width: 700px; margin: 0 auto">
            <input type="hidden" value="${department.id}" name="id">
            <label for="name" class="label-input">
                <span class="input-span">Name</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="name"
                            id="name"
                            class="input"
                            placeholder="Enter your department name"
                            value="${department.name}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="address" class="label-input">
                <span class="input-span">Address</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="address"
                            id="address"
                            class="input"
                            placeholder="Enter your address"
                            value="${department.address}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="phone_number" class="label-input">
                <span class="input-span">Phone Number</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="phone_number"
                            id="phone_number"
                            class="input"
                            placeholder="Enter your phone number"
                            value="${department.phone_number}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="description" class="label-input">
                <span class="input-span">Description</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="description"
                            id="description"
                            class="input"
                            placeholder="Enter your description"
                            value="${department.description}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <button type="submit" class="btn-submit">Submit</button>
        </form>
</div>
</div>
</body>
</html>



