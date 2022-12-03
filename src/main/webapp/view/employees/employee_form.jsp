<%--<%@ page import="com.ngthvu.quanlynhanvienproject.bean.Employee" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Asus--%>
<%--  Date: 11/24/2022--%>
<%--  Time: 11:30 AM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title></title>--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>

<%--<%--%>
<%--    Employee employee = (Employee) request.getAttribute("employee");--%>
<%--%>--%>
<%--    <form enctype="multipart/form-data" method="post"--%>
<%--          id="form_employee" action="${pageContext.request.contextPath}/employee/save"--%>
<%--          onsubmit="return checkDuplicate(this)">--%>

<%--        <input type="text" name="id" id="id" value="<%=employee.getId()%>">--%>
<%--        <input type="text" name="firstname" id="firstname" value="<%=employee.getFirstName()%>">--%>
<%--        <input type="text" name="lastname" id="lastname" value="<%=employee.getLastName()%>">--%>
<%--        <input type="email" name="email" id="email" value="<%=employee.getEmail()%>">--%>
<%--        <input type="date" name="birthday" id="birthday" value="<%=employee.getBirthday()%>">--%>
<%--        <input type="text" name="address" id="address" value="<%=employee.getAddress()%>">--%>
<%--        <input type="text" name="gender" id="gender" value="<%=employee.getGender() == 1 ? "Male" : "Female" %>">--%>
<%--        <input type="text" name="phone" id="phone" value="<%=employee.getPhone()%>">--%>
<%--        <input type="file" name="image" id="image" value="<%=employee.getImage()%>">--%>
<%--        <input type="text" name="id_department" id="id_department" value="<%=employee.getId_department()%>">--%>
<%--        <input type="text" name="id_salary" id="id_salary" value="<%=employee.getId_salary()%>">--%>
<%--        <input type="submit" value="Submit"/>--%>
<%--    </form>--%>
<%--</body>--%>
<%--<script>--%>
<%--    async function checkDuplicateEmail(form) {--%>
<%--        let result = false;--%>
<%--        $.ajax({--%>
<%--            method : 'POST',--%>
<%--            url: '${pageContext.request.contextPath}/employee/checkEmail',--%>
<%--            data: {--%>
<%--                email: $('#email').val(),--%>
<%--                id: $('#id').val()--%>
<%--            },--%>
<%--            success: function(response) {--%>
<%--                if(response === ("Duplicate")) {--%>
<%--                    alert("Email đã tồn tại!");--%>
<%--                    result = false;--%>
<%--                } else if(response === "OK") {--%>
<%--                    result = true;--%>
<%--                }--%>
<%--            },--%>
<%--            error: function(xhr, status, error) {--%>
<%--                alert(status);--%>
<%--                alert(error);--%>
<%--            }--%>
<%--        });--%>
<%--        return result;--%>
<%--    }--%>
<%--    async function checkDuplicatePhone(form) {--%>
<%--        let result = false;--%>
<%--        $.ajax({--%>
<%--            method : 'POST',--%>
<%--            url: '${pageContext.request.contextPath}/employee/checkPhone',--%>
<%--            data: {--%>
<%--                phone: $('#phone').val(),--%>
<%--                id: $('#id').val()--%>
<%--            },--%>
<%--            success: function(response) {--%>
<%--                if(response === ("Duplicate")) {--%>
<%--                    alert("Số điện thoại đã tồn tại!");--%>
<%--                    result = false;--%>
<%--                } else if(response === "OK") {--%>
<%--                    result = true;--%>
<%--                }--%>
<%--            },--%>
<%--            error: function(xhr, status, error) {--%>
<%--                alert(status);--%>
<%--                alert(error);--%>
<%--            }--%>
<%--        });--%>
<%--        return result;--%>
<%--    }--%>

<%--    function checkDuplicate(form) {--%>
<%--        $.ajax({--%>
<%--            method : 'POST',--%>
<%--            url: '${pageContext.request.contextPath}/employee/checkDuplicate',--%>
<%--            data: {--%>
<%--                phone: $('#phone').val(),--%>
<%--                id: $('#id').val(),--%>
<%--                email: $('#email').val()--%>
<%--            },--%>
<%--            success: function(response) {--%>
<%--                if(response === ("OK")) {--%>
<%--                    form.submit();--%>
<%--                    return true;--%>
<%--                } else {--%>
<%--                    alert(response);--%>
<%--                    return false;--%>
<%--                }--%>
<%--            },--%>
<%--            error: function(xhr, status, error) {--%>
<%--                alert(status);--%>
<%--                alert(error);--%>
<%--            }--%>
<%--        });--%>
<%--        return false;--%>
<%--    }--%>
<%--</script>--%>
<%--</html>--%>
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
    <title>Add Employee</title>
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
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/form.css" />--%>
    <script src="${pageContext.request.contextPath}/main.js"></script>
</head>

<body>
<div class="container">
    <jsp:include page="/view/navigation.jsp"></jsp:include>
    <div class="container_form">
        <div>
            <h2 class="text-center">${pageTitle}</h2>
        </div>
        <form name="employee_form" class="form"
              method="post" action="${pageContext.request.contextPath}/employee/save"
              style="max-width: 700px; margin: 0 auto"
              enctype="multipart/form-data"
              onsubmit="return checkDuplicate(this)"
        >
            <input type="hidden" id="id" name="id" value="${employee.id}">
            <label for="firstname" class="label-input">
                <span class="input-span">Firstname</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="firstname"
                            id="firstname"
                            class="input"
                            placeholder="Enter your firstname"
                            value="${employee.firstName}"
                            autofocus
                            required
                    />
                </div>
            </label>

            <label for="lastname" class="label-input">
                <span class="input-span">Lastname</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="lastname"
                            id="lastname"
                            class="input"
                            placeholder="Enter your lastname"
                            value="${employee.lastName}"
                            autofocus
                            required
                    />
                </div>
            </label>

            <label for="email" class="label-input">
                <span class="input-span">Email</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="email"
                            name="email"
                            id="email"
                            class="input"
                            placeholder="Enter your email"
                            value="${employee.email}"
                            autofocus
                            required
                    />
                </div>
            </label>

            <label for="birthday" class="label-input">
                <span class="input-span">Birthday</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="date"
                            name="birthday"
                            id="birthday"
                            class="input"
                            placeholder="Enter your birthday"
                            value="${employee.birthday}"
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
                            value="${employee.address}"
                            autofocus
                            required
                    />
                </div>
            </label>

            <label class="label-input">
                <span class="input-span">Gender</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <span class="input-span">Male</span>
                    <input type="radio" name="gender" id="male" value="1" ${employee.gender == 1 ? "checked" : ""}>
                    <span class="input-span">Female</span>
                    <input type="radio" name="gender" id="female" value="0" ${employee.gender == 0 ? "checked" : ""}>
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
                            placeholder="Enter your phone"
                            value="${employee.phone}"
                            autofocus
                            required
                    />
                </div>
            </label>

            <label for="image" class="label-input">
                <span class="input-span">Image</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="file"
                            accept="image/*"
                            name="image"
                            id="image"
                            class="input"
                            placeholder="Enter your image"
                            value="${employee.image}"
                            autofocus
                            required
                    />
                </div>
            </label>

            <label for="department" class="label-input">
                <span class="input-span">Department</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <select name="id_department" id="department" class="input">
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.id}" ${department.id == employee.id_department ? "selected" : ""}>
                                    ${department.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </label>

            <label for="salary" class="label-input">
                <span class="input-span">Basic Salary</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <select name="id_salary" id="salary" class="input">
                        <c:forEach items="${salaries}" var="salary">
                            <option value="${salary.id}" ${salary.id == employee.id_salary ? "selected" : ""}>${salary.basicSalary}</option>
                        </c:forEach>
                    </select>
                </div>
            </label>

            <button type="submit" class="btn-submit" style="margin-bottom:16px; margin-top: 0!important; ">Submit</button>
        </form>
    </div>
</div>
</body>
<script>
    function checkDuplicate(form) {
            $.ajax({
                method : 'POST',
                url: '${pageContext.request.contextPath}/employee/checkDuplicate',
                data: {
                    phone: $('#phone').val(),
                    id: $('#id').val(),
                    email: $('#email').val()
                },
                success: function(response) {
                    if(response === ("OK")) {
                        form.submit();
                        return true;
                    } else {
                        alert(response);
                        return false;
                    }
                },
                error: function(xhr, status, error) {
                    alert(status);
                    alert(error);
                }
            });
            return false;
    }
</script>
</html>



