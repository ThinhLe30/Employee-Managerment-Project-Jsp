package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "checkDuplicateServlet", value = "/employee/checkDuplicate")
public class checkDuplicateServlet extends HttpServlet {
    EmployeeBO employeeBO;

    public checkDuplicateServlet() {
        employeeBO = new EmployeeBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            String result = employeeBO.checkDuplicate(id, email, phone);
            System.out.println(result);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
