<%@ page import="com.ngthvu.quanlynhanvienproject.entity.EmployeeView" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/29/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            <c:if test = "${not empty sessionScope.admin}">
            <div class="add">
                <a href="employee/add" class="btn" data-toggle="modal">
                    <div class="tooltip">
                        <i class="add-icon fa-solid fa-plus"></i>
                        <p class="tooltiptext">Add new employee</p>
                    </div></a
                >
            </div>
            </c:if>
        </div>
    </div>
<c:if test = "${!empty employees}">
    <table class="table table-striped table-hover table-borderless">
        <thead>
        <tr>
            <th>#</th>
            <th><a href="employees?pageNum=${pageNum}&keyword=${keyword}&fieldName=last_name&orderBy=${reverseOrderBy}">Name</a></th>
            <th><a href="employees?pageNum=${pageNum}&keyword=${keyword}&fieldName=email&orderBy=${reverseOrderBy}">Email</a></th>
            <th><a href="employees?pageNum=${pageNum}&keyword=${keyword}&fieldName=phone_number&orderBy=${reverseOrderBy}">Phone</a></th>
            <th><a href="employees?pageNum=${pageNum}&keyword=${keyword}&fieldName=address&orderBy=${reverseOrderBy}">Address</a></th>
            <th><a href="employees?pageNum=${pageNum}&keyword=${keyword}&fieldName=name&orderBy=${reverseOrderBy}">Department</a></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<EmployeeView> employees = (ArrayList<EmployeeView>) request.getAttribute("employees");
            Long i = (Long) request.getAttribute("startCount");
            for (EmployeeView employeeView : employees) {
        %>
        <tr>
            <td><%=i++%></td>
            <td class="td-name">
                <img
                        src="uploads-img/<%=employeeView.getImage()%>"
                        class="avatar"
                        alt="Avatar"
                /> <%=employeeView.getFirstName() + " " + employeeView.getLastName()%>
            </td>
            <td class="td-mail"><%=employeeView.getEmail()%></td>
            <td><%=employeeView.getPhone()%></td>
            <td><%=employeeView.getAddress()%></td>
            <td><%=employeeView.getDepartmentName()%></td>
            <td class="td-action">
                <button id="detail-toggle-link" onclick="return fetchEmployeeDetail(<%=employeeView.getId()%>);" class="edit">
                    <div class="tooltip">
                        <i class="info-icon fa-solid fa-circle-info"></i>
                        <p class="tooltiptext">Info detail</p>
                    </div></button
                >
                <c:if test = "${not empty sessionScope.admin}">
                <a href="employee/update?id=<%=employeeView.getId()%>" class="edit" data-toggle="modal">
                    <div class="tooltip">
                        <i class="edit-icon fa-solid fa-pen-to-square"></i>
                        <p class="tooltiptext">Edit</p>
                    </div></a
                >
                </c:if>
                <c:if test = "${not empty sessionScope.admin}">
                <a
                        href="employee/delete?id=<%=employeeView.getId()%>"
                        class="delete link-delete"
                        data-toggle="modal"
                >
                    <div class="tooltip">
                        <i class="delete-icon fa-solid fa-trash"></i>
                        <p class="tooltiptext">Delete</p>
                    </div>
                </a>
                </c:if>
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
    <c:if test = "${totalPage > 1}">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-control link-back"
                   href="employees?pageNum=${pageNum == 1 ? pageNum : pageNum -1 }&keyword=${keyword}&fieldName=${fieldName}&orderBy=${orderBy}">
                    <i class="fa-solid fa-arrow-left-long"></i
                    ></a>
            </li>
            <c:forEach var = "i" begin = "1" end = "${totalPage}">
                <li class="page-item ${i == pageNum ? 'active' : ''}"><a href="employees?pageNum=${i}&keyword=${keyword}&fieldName=${fieldName}&orderBy=${orderBy}" class="page-link">${i}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-control link-next"
                   href="employees?pageNum=${pageNum == totalPage ? pageNum : pageNum +1 }&keyword=${keyword}&fieldName=${fieldName}&orderBy=${orderBy}">
                    <i class="fa-solid fa-arrow-right-long"></i
                    ></a>
            </li>
        </ul>
    </c:if>
</div>
<%--Detail modal--%>
    <div id="infoEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h4 class="modal-title">Infomation Of Employee</h4>
                        <button
                                type="button"
                                class="close"
                                data-dismiss="modal"
                                aria-hidden="true"
                        >
                            &times
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label></label>
                            <img id="image" class="avatar" alt="Avatar"  src=""/>
                        </div>
                        <div class="form-group">
                            <label>Name: </label>
                            <span id="name"></span>
                        </div>
                        <div class="form-group">
                            <label>Email:</label>
                            <span id="email"></span>
                        </div>
                        <div class="form-group">
                            <label>Birthday: </label>
                            <span id="birthday"></span>
                        </div>
                        <div class="form-group">
                            <label>Address: </label>
                            <span id="address"></span>
                        </div>
                        <div class="form-group">
                            <label>Gender: </label>
                            <span id="gender"></span>
                        </div>
                        <div class="form-group">
                            <label>Phone: </label>
                            <span id="phone"></span>
                        </div>
                        <div class="form-group">
                            <label for="department">Department: </label>
                            <span id="department"></span>
                        </div>
                        <div class="form-group">
                            <label for="salary">Salary</label>
                            <span id="salary"></span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input
                                type="button"
                                class="btn btn-default"
                                data-dismiss="modal"
                                value="Cancel"
                        />
                    </div>
                </form>
            </div>
        </div>
    </div>
<%--Delete modal--%>
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
</body>

<script>
    function fetchEmployeeDetail(id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/employee/detail",
            method: "GET",
            data: {
                id: id
            },
            success: function (response) {
                $(`#name`).html(response.split("/")[0]);
                $(`#email`).html(response.split("/")[1]);
                $(`#birthday`).html(response.split("/")[2]);
                $(`#address`).html(response.split("/")[3]);
                let gender = response.split("/")[4] === "1" ? "Male" : "Female";
                $(`#gender`).html(gender);
                $(`#phone`).html(response.split("/")[5]);
                $(`#image`).attr("src", 'uploads-img/' + response.split("/")[6]);
                $(`#department`).html(response.split("/")[7]);
                $(`#salary`).html(response.split("/")[8]+"$");
                $("#infoEmployeeModal").modal();
            },
            error: function (error) {
                console.log(error);
            },
        });
    }
    $(document).ready(function (){
        $(".link-delete").click(function (e){
            e.preventDefault();
            $("#deleteEmployeeModal").modal();
            $(".but-delete").attr("href",$(this).attr("href"));
        })
        $(".link-back").click(function (e){
            if(${pageNum  == 1 }){
                e.preventDefault();
            }
        })
        $(".link-next").click(function (e){
            if(${pageNum  == totalPage }){
                e.preventDefault();
            }
        })
    })
</script>
</html>
