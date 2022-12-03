package com.ngthvu.quanlynhanvienproject.controller.salaries;

import com.ngthvu.quanlynhanvienproject.exception.SalaryNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.SalaryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteSalaryServlet", value = "/salary/delete")
public class DeleteSalaryServlet extends HttpServlet {
    private SalaryBO salaryBO;
    public void init(){
        salaryBO = new SalaryBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            salaryBO.delete(id);
            response.sendRedirect(request.getContextPath()+"/salaries");
        } catch (SalaryNotFoundException e) {
            request.getRequestDispatcher("/view/error/404.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
