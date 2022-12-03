package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.service.DepartmentService;
import com.ngthvu.quanlynhanvienproject.service.EmployeeService;
import com.ngthvu.quanlynhanvienproject.service.SalaryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateEmployeeServlet", value = "/employee/update")
public class UpdateEmployeeServlet extends HttpServlet {
    EmployeeService employeeService;
    DepartmentService departmentService;
    SalaryService salaryService;
    // Controller, contact only with View and Service, do not linked Controller to Repository!

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeService();
        departmentService = new DepartmentService();
        salaryService = new SalaryService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); //
        System.out.println("id = " + id);
        try {
            Employee employee = employeeService.get(id);
            System.out.print(employee.getId_department());
            System.out.print(employee.getId_salary());
            ArrayList<Department> departments = departmentService.getAll();
            ArrayList<Salary> salaries = salaryService.getAll();
            request.setAttribute("departments", departments);
            request.setAttribute("salaries", salaries);
            request.setAttribute("employee", employee);
            request.setAttribute("pageTitle", "Update Employee");
            RequestDispatcher rd = request.getRequestDispatcher("/view/employees/employee_form_demo.jsp");
            rd.forward(request, response);
        } catch (EmployeeNotFoundException e) {
            RequestDispatcher rdError = request.getRequestDispatcher("view/error/404.jsp");
            request.setAttribute("error", e.getMessage());
            rdError.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
