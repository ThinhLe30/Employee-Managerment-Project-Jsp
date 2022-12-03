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
        <form name="admin_form" class="form"
              method="post" action="${pageContext.request.contextPath}/admin/save"
              style="max-width: 700px; margin: 0 auto">
            <input type="hidden" value="${admin.id}" name="id">
            <label for="name" class="label-input">
                <span class="input-span">Username</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="username"
                            id="name"
                            class="input"
                            placeholder="Enter your username"
                            value="${admin.username}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="password" class="label-input">
                <span class="input-span">Password</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="password"
                            name="password"
                            id="password"
                            class="input"
                            placeholder="Enter your password"
                            oninput="checkPasswordMatch(document.getElementById('re-password'))"
                            value="${admin.password}"
                            required
                    />
                </div>
            </label>
            <label for="re-password" class="label-input">
                <span class="input-span">Reenter Password</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="password"
                            name="re-password"
                            id="re-password"
                            class="input"
                            placeholder="Reenter your password"
                            oninput="checkPasswordMatch(this)"
                            value="${admin.password}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="first_name" class="label-input">
                <span class="input-span">First Name</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="first_name"
                            id="first_name"
                            class="input"
                            placeholder="Enter your first name"
                            value="${admin.firstName}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="last_name" class="label-input">
                <span class="input-span">Last Name</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="last_name"
                            id="last_name"
                            class="input"
                            placeholder="Enter your last name"
                            value="${admin.lastName}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="phone" class="label-input">
                <span class="input-span">Phone Number</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="phone"
                            id="phone"
                            class="input"
                            placeholder="Enter your phone number"
                            value="${admin.phone}"
                            onkeypress='return event.charCode >= 48 && event.charCode <= 57'
                            autofocus
                            required
                    />
                </div>
            </label>
            <button type="submit" class="btn-submit">Submit</button>
        </form>
</div>
</div>
<script>
    function checkPasswordMatch(confirmPassword){
        if (confirmPassword.value != $("#password").val()) {
            confirmPassword.setCustomValidity("Passwords do not match!");
        } else {
            confirmPassword.setCustomValidity("");
        }
    }
</script>
</body>
</html>



