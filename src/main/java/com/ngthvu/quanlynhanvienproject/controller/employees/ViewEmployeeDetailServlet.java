package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.bean.EmployeeView;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewEmployeeDetailServlet", value = "/employee/detail")
public class ViewEmployeeDetailServlet extends HttpServlet {
    EmployeeBO employeeBO;

    public ViewEmployeeDetailServlet() {
        employeeBO = new EmployeeBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                EmployeeView employeeView = employeeBO.getView(id);
                response.getWriter().print(employeeView.getInfo());
            }
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
