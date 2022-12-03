package com.ngthvu.quanlynhanvienproject.bo;

import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.exception.SalaryNotFoundException;
import com.ngthvu.quanlynhanvienproject.dao.SalaryDAO;

import java.util.ArrayList;
import java.util.List;

public class SalaryBO {
    // represent BO, contact with controller and Repository
    private SalaryDAO salaryDAO;
    public SalaryBO(){
        salaryDAO = new SalaryDAO();
    }

    public ArrayList<Salary> getAll(){
        return salaryDAO.findAll();
    }
    public List<Salary> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy) {
        return salaryDAO.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }

    public Integer countByKeyword(String keyword) {
        return salaryDAO.countByKeyword(keyword);
    }
    public Salary findById(Integer id) throws SalaryNotFoundException {
        Salary salary = salaryDAO.findById(id);
        if(salary == null){
            throw new SalaryNotFoundException("Salary not found with id:" + id);
        }
        return salary;
    }

    public void save(Salary salary) {
        if(salary.getId() == 0){
            salaryDAO.add(salary);
        }
        else{
            salaryDAO.update(salary);
        }
    }

    public void delete(Integer id) throws SalaryNotFoundException {
        if(salaryDAO.findById(id) == null){
            throw new SalaryNotFoundException("Salary not found with id:" + id);
        }
        salaryDAO.delete(id);
    }
}
