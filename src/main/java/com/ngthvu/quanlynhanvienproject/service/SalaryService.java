package com.ngthvu.quanlynhanvienproject.service;

import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.exception.SalaryNotFoundException;
import com.ngthvu.quanlynhanvienproject.repository.SalaryRepository;

import java.util.ArrayList;
import java.util.List;

public class SalaryService {
    // represent BO, contact with controller and Repository
    private SalaryRepository salaryRepository;
    public SalaryService(){
        salaryRepository = new SalaryRepository();
    }

    public ArrayList<Salary> getAll(){
        return salaryRepository.findAll();
    }
    public List<Salary> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy) {
        return salaryRepository.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }

    public Integer countByKeyword(String keyword) {
        return salaryRepository.countByKeyword(keyword);
    }
    public Salary findById(Integer id) throws SalaryNotFoundException {
        Salary salary = salaryRepository.findById(id);
        if(salary == null){
            throw new SalaryNotFoundException("Salary not found with id:" + id);
        }
        return salary;
    }

    public void save(Salary salary) {
        if(salary.getId() == 0){
            salaryRepository.add(salary);
        }
        else{
            salaryRepository.update(salary);
        }
    }

    public void delete(Integer id) throws SalaryNotFoundException {
        if(salaryRepository.findById(id) == null){
            throw new SalaryNotFoundException("Salary not found with id:" + id);
        }
        salaryRepository.delete(id);
    }
}
