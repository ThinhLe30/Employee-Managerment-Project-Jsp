package com.ngthvu.quanlynhanvienproject.service;

import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.EmployeeView;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    // represent BO, contact with controller and Repository
    private final EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    public Integer countByKeyword(String keyword) {
        return employeeRepository.countByKeyword(keyword);
    }

    public List<EmployeeView> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        return employeeRepository.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }
    public ArrayList<Employee> getAll() {
        return employeeRepository.getAll();
    }

//    public ArrayList<EmployeeView> getAllView() {
//        return employeeRepository.getAllView();
//    }

    public Employee get (int id) throws EmployeeNotFoundException {
        if (employeeRepository.get(id).getId() == 0) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        else return employeeRepository.get(id);
    }

    public EmployeeView getView(int id) throws EmployeeNotFoundException {
        if (employeeRepository.getView(id).getId() == 0) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        else return employeeRepository.getView(id);
    }

    public Employee get(String type, String value) {
        return employeeRepository.get(type, value);
    }

    public EmployeeView getView(String type, String value) throws EmployeeNotFoundException {
        return employeeRepository.getView(type, value);
    }

    public void delete(int id) throws EmployeeNotFoundException {
        if (employeeRepository.get(id).getId() == 0) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        } else {
            employeeRepository.delete(id);
        }
    }

    public ArrayList<Employee> search(String keyword) {
        return employeeRepository.search(keyword);
    }

    public String checkDuplicate(int id, String email, String phone) {
        return employeeRepository.checkDuplicate(id, email, phone);
    }

    public void save(Employee employee) throws EmployeeNotFoundException {
        System.out.println(employee.getId());
        if(employee.getId() == 0) {
            employeeRepository.add(employee);
        } else {
            if (employeeRepository.get(employee.getId()) == null) {
                throw new EmployeeNotFoundException("Employee not found with id: " + employee.getId());
            } else {
                employeeRepository.update(employee);
            }
        }
    }
}
