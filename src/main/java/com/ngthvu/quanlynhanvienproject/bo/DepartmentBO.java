package com.ngthvu.quanlynhanvienproject.bo;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.exception.DepartmentNotFoundException;
import com.ngthvu.quanlynhanvienproject.dao.DepartmentDAO;

import java.util.ArrayList;
import java.util.List;

public class DepartmentBO {
    // represent BO, contact with controller and Repository
    private final DepartmentDAO departmentDAO;

    public DepartmentBO(){
        departmentDAO = new DepartmentDAO();
    }
    public List<Department> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        return departmentDAO.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }
    public Integer countByKeyword(String keyword) {
        return departmentDAO.countByKeyword(keyword);
    }
    public ArrayList<Department> getAll(){
        return departmentDAO.getAll();
    }

    public ArrayList<Department> search(String keyword){
        return departmentDAO.search(keyword);
    }

    public Department get(Integer id) throws DepartmentNotFoundException {
        Department department = departmentDAO.get(id);
        if(department == null){
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
        return department;
    }

    public Department get(String type, String value) throws DepartmentNotFoundException {
        Department department = departmentDAO.get(type, value);
        if(department == null){
            throw new DepartmentNotFoundException("Department not found with " + type + " = " + value);
        }
        return department;
    }

    public void add(Department department) throws Exception {
        departmentDAO.add(department);
    }

    public void update(Department department) throws Exception {
        departmentDAO.update(department);
    }

    public void delete(Integer id) throws Exception {
        departmentDAO.delete(id);
    }

    public void save(Department department) throws Exception {
        if(department.getId() == 0){
            departmentDAO.add(department);
        }
        else{
            departmentDAO.update(department);
        }
    }
}
