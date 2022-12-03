package com.ngthvu.quanlynhanvienproject.controller.departments;

import com.ngthvu.quanlynhanvienproject.bean.Department;
import com.ngthvu.quanlynhanvienproject.exception.DepartmentNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.DepartmentBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/department/update")
public class UpdateDepartmentServlet extends HttpServlet {
    DepartmentBO departmentBO;
    @Override
    public void init() throws ServletException {
        departmentBO = new DepartmentBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            Department department  = departmentBO.get(id);
            request.setAttribute("department", department);
            request.setAttribute("pageTitle", "Update Department");
            request.getRequestDispatcher("/view/departments/department_form.jsp").forward(request,response);
        } catch (DepartmentNotFoundException e) {
            RequestDispatcher rdError = request.getRequestDispatcher("view/error/404.jsp");
            request.setAttribute("error", e.getMessage());
            rdError.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
