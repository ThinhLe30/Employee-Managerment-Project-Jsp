package com.ngthvu.quanlynhanvienproject.controller.departments;

import com.ngthvu.quanlynhanvienproject.bo.DepartmentBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteDepartmentServlet", value = "/department/delete")
public class DeleteDepartmentServlet extends HttpServlet {
    DepartmentBO departmentBO;

    @Override
    public void init() throws ServletException {
        departmentBO = new DepartmentBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            departmentBO.delete(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect(request.getContextPath()+"/departments");
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("view/error/404.jsp");
            request.setAttribute("error", e.getMessage());
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
