<%@ page import="com.ngthvu.quanlynhanvienproject.entity.EmployeeView" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.entity.Salary" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.entity.Employee" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/form.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/index.css" />

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
        <form name="employee_form" class="form"
              method="post" action="${pageContext.request.contextPath}/employee/save"
              enctype="multipart/form-data"
              style="max-width: 700px; margin: 0 auto"
                onsubmit="return checkDuplicate(this);"
        >
            <input type="hidden" id="id" value="${employee.id}" name="id">
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
                            value="${employee.birthday}"
                            placeholder="Enter your birthday"
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
                    <input type="radio" class="radio-input" name="gender" id="male" value="1" ${employee.gender == 1 ? "checked" : ""}>
                    <span class="input-span">Female</span>
                    <input type="radio" class="radio-input" name="gender" id="female" value="0" ${employee.gender == 0 ? "checked" : ""}>
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
                            onkeypress='return event.charCode >= 48 && event.charCode <= 57'
                            autofocus
                            required
                    />
                </div>
            </label>
            <input type="hidden" name="image_name" value="${employee.image}">
            <label for="image" class="label-input">
                <span class="input-span">Image</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="file"
                            name="image"
                            id="image"
                            class="input"
                            placeholder="Enter your image"
                            onchange="previewFile(this);"
                            autofocus
                    />
                    <div class="avatar-form-container text-center">
                        <c:set var="path" value="${ pageContext.request.getContextPath()}" />
                        <c:set var="path_target" value="uploads-img/" />
                        <img
                                src="${pageContext.request.contextPath}/uploads-img/${employee.image}"
                                class="avatar-form"
                                alt="Avatar"
                        ${employee.image == "" ? "hidden" : ""}
                        />
                    </div>
                </div>

            </label>

            <label for="department" class="label-input">
                <span class="input-span">Department</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <select name="id_department" id="department" class="input">
                        <c:if test = "${employee.id_department == 0}">
                            <option value="0" selected}>None</option>
                        </c:if>
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.id}" ${employee.id_department == department.id ? "selected" : ""}>${department.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </label>

            <label for="salary" class="label-input">
                <span class="input-span">Basic Salary</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <select name="id_salary" id="salary" class="input">
                        <c:if test = "${employee.id_salary == 0}">
                            <option value="0" selected}>None</option>
                        </c:if>
                        <c:forEach items="${salaries}" var="salary">
                            <option value="${salary.id}" ${employee.id_salary == salary.id ? "selected" : ""}>$${salary.basicSalary}</option>
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

    function previewFile(input) {
        var file = $("input[type=file]").get(0).files[0];
        if(file) {
            var reader = new FileReader();
            reader.onload = function() {
                $(".avatar-form").attr("src", reader.result);
                $(".avatar-form").attr("hidden", false);
            }
            reader.readAsDataURL(file);
        }
    }
</script>

</html>



