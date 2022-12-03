package com.ngthvu.quanlynhanvienproject.controller.departments;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.bo.DepartmentBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddDepartmentServlet", value = "/department/add")
public class AddDepartmentServlet extends HttpServlet {
    DepartmentBO departmentBO;
    @Override
    public void init() throws ServletException {
        departmentBO = new DepartmentBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();
        request.setAttribute("department", department);
        request.setAttribute("pageTitle", "Add Department");
        request.getRequestDispatcher("/view/departments/department_form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
