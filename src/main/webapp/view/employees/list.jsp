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
    <title>Manage Employee</title>
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
    <script src="${pageContext.request.contextPath}/main.js"></script>
</head>

<body>
<div class="container">
    <jsp:include page="/view/navigation.jsp"></jsp:include>
    <div>
        <div class="table-responsive">
            <div class="table-wrapper">
                <div class="tabel-title">
                    <p>Manage</p>
                    <i class="fa-solid fa-circle"></i>
                    <p class="text">Employee</p>
                </div>
                <div class="table-control">
                    <div class="search">
                        <form action="employees" method="get">
                            <input
                                    name="keyword"
                                    type="search"
                                    class="search-input"
                                    id="search-input"
                                    placeholder="Search"
                                    autocomplete="off"
                                    value="${keyword}"
                            />
                        </form>
                        <i class="search-icon fa-solid fa-magnifying-glass"></i>
                    </div>
                    <div class="add">
                        <a href="employee/add" class="btn">
                            <div class="tooltip">
                                <i class="add-icon fa-solid fa-plus"></i>
                                <p class="tooltiptext">Add new employee</p>
                            </div></a
                        >
                    </div>
                </div>
            </div>
            <c:if test = "${!empty employees}">
                <table class="table table-striped table-hover table-borderless">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th></th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Department</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<EmployeeView> employees = (ArrayList<EmployeeView>) request.getAttribute("employees");
                        int i = 1;
                        for (EmployeeView employeeView : employees) {
                    %>
                    <tr>
                        <td><%=i++%></td>
                        <td class="td-name">
                            <img
                                    src="view/uploads/<%=employeeView.getImage()%>"
                                    class="avatar"
                                    alt="Avatar"
                            /> <%=employeeView.getFirstName() + " " + employeeView.getLastName()%>
                        </td>
                        <td><%=employeeView.toString()%></td>
                        <td><%=employeeView.getEmail()%></td>
                        <td><%=employeeView.getPhone()%></td>
                        <td><%=employeeView.getAddress()%></td>
                        <td><%=employeeView.getDepartmentName()%></td>
                        <td class="td-action">
                            <a href="employee/detail?id=<%=employeeView.getId()%>" class="edit" data-toggle="modal">
                                <div class="tooltip">
                                    <i class="info-icon fa-solid fa-circle-info"></i>
                                    <p class="tooltiptext">Info detail</p>
                                </div></a
                            >
                            <a href="employee/update?id=<%=employeeView.getId()%>" class="edit" data-toggle="modal">
                                <div class="tooltip">
                                    <i class="edit-icon fa-solid fa-pen-to-square"></i>
                                    <p class="tooltiptext">Edit</p>
                                </div>
                            </a>
                            <a href="employee/delete?id=<%=employeeView.getId()%>" class="delete link-delete"
                               data-toggle="modal">
                                <div class="tooltip">
                                    <i class="delete-icon fa-solid fa-trash"></i>
                                    <p class="tooltiptext">Delete</p>
                                </div>
                            </a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </c:if>
            <c:if test = "${empty employees}">
                <div>
                    <h3><p class="text text-center">No matches found.</p></h3>
                </div>
            </c:if>

            <div id="deleteEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">
                                <h4 class="modal-title">Delete Employee</h4>
                                <button
                                        type="button"
                                        class="close"
                                        data-dismiss="modal"
                                        aria-hidden="true"
                                >
                                    &times;
                                </button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure you want to delete this employee?</p>
                                <p class="text-warning">
                                    <small>This action cannot be undone.</small>
                                </p>
                            </div>
                            <div class="modal-footer">
                                <input
                                        type="button"
                                        class="btn btn-default"
                                        data-dismiss="modal"
                                        value="Cancel"
                                />
                                <a href="" class="btn btn-danger but-delete">Delete</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>



