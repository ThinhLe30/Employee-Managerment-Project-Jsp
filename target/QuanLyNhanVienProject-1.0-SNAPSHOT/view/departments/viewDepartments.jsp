<%@ page import="java.util.List" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.entity.Department" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/25/2022
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Department> departments = (List<Department>) request.getAttribute("departments");
        for(Department department : departments){
    %>
            <p><%= department.toString() %></p>
        <%}
    %>
</body>
</html>
