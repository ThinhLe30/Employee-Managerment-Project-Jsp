package com.ngthvu.quanlynhanvienproject.controller.departments;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.service.DepartmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveDepartmentServlet", value = "/department/save")
public class SaveDepartmentServlet extends HttpServlet {
    DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        departmentService = new DepartmentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();
        department.setId(Integer.valueOf(request.getParameter("id")));
        department.setName(request.getParameter("name"));
        department.setAddress(request.getParameter("address"));
        department.setPhone_number(request.getParameter("phone_number"));
        department.setDescription(request.getParameter("description"));
        try {
            departmentService.save(department);
            response.sendRedirect(request.getContextPath()+"/departments");
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("view/error/404.jsp");
//            request.setAttribute("error", e.getMessage());
            rd.forward(request, response);
        }
    }
}
