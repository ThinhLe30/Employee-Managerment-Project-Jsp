package com.ngthvu.quanlynhanvienproject.controller.employees;

import com.ngthvu.quanlynhanvienproject.bean.Department;
import com.ngthvu.quanlynhanvienproject.bean.Employee;
import com.ngthvu.quanlynhanvienproject.bean.Salary;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.bo.DepartmentBO;
import com.ngthvu.quanlynhanvienproject.bo.EmployeeBO;
import com.ngthvu.quanlynhanvienproject.bo.SalaryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateEmployeeServlet", value = "/employee/update")
public class UpdateEmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO;
    DepartmentBO departmentBO;
    SalaryBO salaryBO;
    // Controller, contact only with View and Service, do not linked Controller to Repository!

    @Override
    public void init() throws ServletException {
        employeeBO = new EmployeeBO();
        departmentBO = new DepartmentBO();
        salaryBO = new SalaryBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); //
        System.out.println("id = " + id);
        try {
            Employee employee = employeeBO.get(id);
            System.out.print(employee.getId_department());
            System.out.print(employee.getId_salary());
            ArrayList<Department> departments = departmentBO.getAll();
            ArrayList<Salary> salaries = salaryBO.getAll();
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
