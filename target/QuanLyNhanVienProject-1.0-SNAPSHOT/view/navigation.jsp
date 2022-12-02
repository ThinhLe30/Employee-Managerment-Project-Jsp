<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="side">
    <div class="title">
        <img src="${pageContext.request.contextPath}/view/img/logo/office.png" alt="" />
        <p>Management</p>
    </div>
    <ul class="navigation">
        <c:if test = "${not empty sessionScope.admin}">
        <li class="nav-list">
            <p class="nav-text" style="color: #282828">Welcome, <b>${sessionScope.admin.fullname}</b></p>
        </li>
        </c:if>
        <li class="nav-list">
            <i class="nav-icon fa-solid fa-users"></i>
            <a class="nav-text" href="${pageContext.request.contextPath}/employees">Employees</a>
        </li>
        <li class="nav-list">
            <i class="nav-icon fa-solid fa-building-user"></i>
            <a class="nav-text" href="${pageContext.request.contextPath}/departments">Departments</a>
        </li>
        <li class="nav-list">
            <i class="nav-icon fa-solid fa-file-invoice-dollar"></i>
            <a class="nav-text" href="${pageContext.request.contextPath}/salaries">Salaries Level</a>
        </li>
        <c:if test = "${not empty sessionScope.admin}">
        <li class="nav-list">
            <i class="nav-icon fa-solid fa-user"></i>
            <a class="nav-text" href="${pageContext.request.contextPath}/admins">Admins</a>
        </li>
        </c:if>
    </ul>
    <c:if test = "${not empty sessionScope.admin}">
    <div class="logout">
        <div class="btn-logout">
            <a href="${pageContext.request.contextPath}/logout">
                Log out
                <i class="fa-solid fa-right-from-bracket"></i>
            </a>
        </div>
    </div>
    </c:if>
    <c:if test = "${empty sessionScope.admin}">
        <div class="logout">
            <div class="btn-logout">
                <a href="${pageContext.request.contextPath}/login">
                    Log in
                    <i class="fa-solid fa-arrow-up-from-bracket"></i>
                </a>
            </div>
        </div>
    </c:if>
</div>