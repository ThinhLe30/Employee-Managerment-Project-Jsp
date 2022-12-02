package com.ngthvu.quanlynhanvienproject.service;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.exception.DepartmentNotFoundException;
import com.ngthvu.quanlynhanvienproject.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    // represent BO, contact with controller and Repository
    private final DepartmentRepository departmentRepository;

    public DepartmentService(){
        departmentRepository = new DepartmentRepository();
    }
    public List<Department> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        return departmentRepository.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }
    public Integer countByKeyword(String keyword) {
        return departmentRepository.countByKeyword(keyword);
    }
    public ArrayList<Department> getAll(){
        return departmentRepository.getAll();
    }

    public ArrayList<Department> search(String keyword){
        return departmentRepository.search(keyword);
    }

    public Department get(Integer id) throws DepartmentNotFoundException {
        Department department = departmentRepository.get(id);
        if(department == null){
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
        return department;
    }

    public Department get(String type, String value) throws DepartmentNotFoundException {
        Department department = departmentRepository.get(type, value);
        if(department == null){
            throw new DepartmentNotFoundException("Department not found with " + type + " = " + value);
        }
        return department;
    }

    public void add(Department department) throws Exception {
        departmentRepository.add(department);
    }

    public void update(Department department) throws Exception {
        departmentRepository.update(department);
    }

    public void delete(Integer id) throws Exception {
        departmentRepository.delete(id);
    }

    public void save(Department department) throws Exception {
        if(department.getId() == 0){
            departmentRepository.add(department);
        }
        else{
            departmentRepository.update(department);
        }
    }
}
