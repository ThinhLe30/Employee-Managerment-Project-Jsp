package com.ngthvu.quanlynhanvienproject.bo;

import com.ngthvu.quanlynhanvienproject.bean.Employee;
import com.ngthvu.quanlynhanvienproject.bean.EmployeeView;
import com.ngthvu.quanlynhanvienproject.exception.EmployeeNotFoundException;
import com.ngthvu.quanlynhanvienproject.dao.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBO {
    // represent BO, contact with controller and Repository
    private final EmployeeDAO employeeDAO;

    public EmployeeBO() {
        employeeDAO = new EmployeeDAO();
    }

    public Integer countByKeyword(String keyword) {
        return employeeDAO.countByKeyword(keyword);
    }

    public List<EmployeeView> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        return employeeDAO.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }
    public ArrayList<Employee> getAll() {
        return employeeDAO.getAll();
    }

//    public ArrayList<EmployeeView> getAllView() {
//        return employeeRepository.getAllView();
//    }

    public Employee get (int id) throws EmployeeNotFoundException {
        if (employeeDAO.get(id).getId() == 0) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        else return employeeDAO.get(id);
    }

    public EmployeeView getView(int id) throws EmployeeNotFoundException {
        if (employeeDAO.getView(id).getId() == 0) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        else return employeeDAO.getView(id);
    }

    public Employee get(String type, String value) {
        return employeeDAO.get(type, value);
    }

    public EmployeeView getView(String type, String value) throws EmployeeNotFoundException {
        return employeeDAO.getView(type, value);
    }

    public void delete(int id) throws EmployeeNotFoundException {
        if (employeeDAO.get(id).getId() == 0) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        } else {
            employeeDAO.delete(id);
        }
    }

    public ArrayList<Employee> search(String keyword) {
        return employeeDAO.search(keyword);
    }

    public String checkDuplicate(int id, String email, String phone) {
        return employeeDAO.checkDuplicate(id, email, phone);
    }

    public void save(Employee employee) throws EmployeeNotFoundException {
        System.out.println(employee.getId());
        if(employee.getId() == 0) {
            employeeDAO.add(employee);
        } else {
            if (employeeDAO.get(employee.getId()) == null) {
                throw new EmployeeNotFoundException("Employee not found with id: " + employee.getId());
            } else {
                employeeDAO.update(employee);
            }
        }
    }
}
