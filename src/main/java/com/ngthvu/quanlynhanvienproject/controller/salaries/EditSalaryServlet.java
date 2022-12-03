package com.ngthvu.quanlynhanvienproject.controller.salaries;

import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.exception.SalaryNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.SalaryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditSalaryServlet", value = "/salary/update")
public class EditSalaryServlet extends HttpServlet {
    private SalaryBO salaryBO;
    public void init(){
        salaryBO = new SalaryBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            Salary salary = salaryBO.findById(id);
            request.setAttribute("salary",salary);
            request.setAttribute("pageTitle","Update Salary");
            request.getRequestDispatcher("/view/salaries/salary_form.jsp").forward(request,response);
        } catch (SalaryNotFoundException e) {
            request.getRequestDispatcher("/view/error/404.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
