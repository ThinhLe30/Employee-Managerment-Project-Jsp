<%@ page import="com.ngthvu.quanlynhanvienproject.entity.EmployeeView" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.entity.Salary" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Add Salary</title>
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
        <form name="salary_form" class="form"
              method="post" action="${pageContext.request.contextPath}/salary/save"
              style="max-width: 700px; margin: 0 auto">
            <input type="hidden" value="${salary.id}" name="id">
            <label for="basic_salary" class="label-input">
                <span class="input-span">Basic Salary</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="basic_salary"
                            id="basic_salary"
                            class="input"
                            placeholder="Enter your basic salary"
                            value="${salary.basicSalary}"
                            autofocus
                            required

                    />
                </div>
            </label>
            <label for="coefficient_pay" class="label-input">
                <span class="input-span">Coefficient Pay</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="coefficient_pay"
                            id="coefficient_pay"
                            class="input"
                            placeholder="Enter your coefficient pay"
                            value="${salary.coefficientPay}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <label for="coefficient_allowance" class="label-input">
                <span class="input-span">Coefficient Allowance</span>
                <div class="input-container">
                    <i class="ph-envelope"></i>
                    <input
                            type="text"
                            name="coefficient_allowance"
                            id="coefficient_allowance"
                            class="input"
                            placeholder="Enter your coefficient allowance"
                            value="${salary.coeficientAllowance}"
                            autofocus
                            required
                    />
                </div>
            </label>
            <button type="submit" class="btn-submit">Submit</button>
        </form>
<%--        <form method="post" action="${pageContext.request.contextPath}/salary/save"--%>
<%--              style="max-width: 700px; margin: 0 auto">--%>
<%--            <div class="border border-secondary rounded p-3">--%>
<%--                <input type="hidden" name="id" id="id" value="${salary.id}">--%>
<%--                <div class="form-group">--%>
<%--                    <label for="basic_salary">Basic Salary</label>--%>
<%--                    <input class="form-control" type="text" name="basic_salary" id="basic_salary" value="${salary.basicSalary}"--%>
<%--                           onkeypress='return event.charCode >= 48 && event.charCode <= 57' required>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="coefficient_pay">Coefficient Pay</label>--%>
<%--                    <input class="form-control" type="number" min="0" max="5" step="0.01" name="coefficient_pay"--%>
<%--                           id="coefficient_pay" value="${salary.coefficientPay}" required>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="coeficient_allowance">Coeficient Allowance</label>--%>
<%--                    <input class="form-control" type="number" min="0" max="5" step="0.01" name="coeficient_allowance"--%>
<%--                           id="coeficient_allowance" value="${salary.coeficientAllowance}" required>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="text-center">--%>
<%--                <input--%>
<%--                        style="width: 70px"--%>
<%--                        type="submit"--%>
<%--                        class="btn btn-primary"--%>
<%--                        value="Save"--%>
<%--                />--%>
<%--                &nbsp;&nbsp;--%>
<%--                <input--%>
<%--                        style="width: 70px"--%>
<%--                        type="button"--%>
<%--                        class="btn btn-default"--%>
<%--                        value="Cancel"--%>
<%--                        onclick="window.location='${pageContext.request.contextPath}/salaries'"--%>
<%--                />--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
</div>
</div>
</body>
</html>



