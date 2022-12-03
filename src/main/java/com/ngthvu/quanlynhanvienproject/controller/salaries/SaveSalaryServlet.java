package com.ngthvu.quanlynhanvienproject.controller.salaries;

import com.ngthvu.quanlynhanvienproject.bean.Salary;
import com.ngthvu.quanlynhanvienproject.bo.SalaryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveSalaryServlet", value = "/salary/save")
public class SaveSalaryServlet extends HttpServlet {
    private SalaryBO salaryBO;
    public void init(){
        salaryBO = new SalaryBO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Float basic_salary = Float.parseFloat(request.getParameter("basic_salary"));
        Float coefficient_pay = Float.parseFloat(request.getParameter("coefficient_pay"));
        Float coeficient_allowance = Float.parseFloat(request.getParameter("coefficient_allowance"));
        Salary salary = new Salary(id,basic_salary,coefficient_pay,coeficient_allowance);
        salaryBO.save(salary);
        response.sendRedirect(request.getContextPath()+"/salaries");
    }
}
