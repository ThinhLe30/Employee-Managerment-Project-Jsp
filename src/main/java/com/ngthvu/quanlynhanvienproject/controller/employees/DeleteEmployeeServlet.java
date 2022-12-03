package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", value = "/employee/delete")
public class DeleteEmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO;
    // Controller, contact only with View and Service, do not linked Controller to Repository!

    public DeleteEmployeeServlet() {
        employeeBO = new EmployeeBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            employeeBO.delete(id);
            response.sendRedirect(request.getContextPath()+"/employees");
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            RequestDispatcher rdError = request.getRequestDispatcher("view/error/404.jsp");
            request.setAttribute("error", e.getMessage());
            rdError.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
