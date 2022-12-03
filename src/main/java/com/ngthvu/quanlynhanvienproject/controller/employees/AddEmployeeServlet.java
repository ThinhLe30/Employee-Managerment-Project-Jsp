package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.bo.DepartmentBO;
import com.ngthvu.quanlynhanvienproject.bo.SalaryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

@WebServlet(name = "AddEmployeeServlet", value = "/employee/add")
public class AddEmployeeServlet extends HttpServlet {
    DepartmentBO departmentBO;
    SalaryBO salaryBO;
    // Controller, contact only with View and Service, do not link Controller to Repository!

    @Override
    public void init() throws ServletException {
        departmentBO = new DepartmentBO();
        salaryBO = new SalaryBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee(0,"","","", new Date(),"",1,"","",1,1);
        ArrayList<Department> departments = departmentBO.getAll();
        ArrayList<Salary> salaries = salaryBO.getAll();
        request.setAttribute("employee", employee);
        request.setAttribute("departments", departments);
        request.setAttribute("salaries", salaries);
        request.setAttribute("pageTitle", "Add Employee");
        RequestDispatcher rd = request.getRequestDispatcher("/view/employees/employee_form_demo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
