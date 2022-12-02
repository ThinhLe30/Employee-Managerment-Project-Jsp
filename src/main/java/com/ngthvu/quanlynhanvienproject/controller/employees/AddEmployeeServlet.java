package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.service.DepartmentService;
import com.ngthvu.quanlynhanvienproject.service.SalaryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddEmployeeServlet", value = "/employee/add")
public class AddEmployeeServlet extends HttpServlet {
    DepartmentService departmentService;
    SalaryService salaryService;
    // Controller, contact only with View and Service, do not link Controller to Repository!

    @Override
    public void init() throws ServletException {
        departmentService = new DepartmentService();
        salaryService = new SalaryService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee(0,"","","", new Date(),"",1,"","",1,1);
        ArrayList<Department> departments = departmentService.getAll();
        ArrayList<Salary> salaries = salaryService.getAll();
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
