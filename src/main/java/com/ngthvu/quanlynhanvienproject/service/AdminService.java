package com.ngthvu.quanlynhanvienproject.service;

import com.ngthvu.quanlynhanvienproject.entity.Admin;
import com.ngthvu.quanlynhanvienproject.exception.AdminNotFoundException;
import com.ngthvu.quanlynhanvienproject.repository.AdminRepository;
import com.ngthvu.quanlynhanvienproject.repository.DepartmentRepository;

import java.util.List;

public class AdminService {
    // represent BO, contact with controller and Repository
    private AdminRepository adminRepository;
    public AdminService(){
        adminRepository = new AdminRepository();
    }
    public boolean isValidAdmin(String username, String password){
        return adminRepository.isValidAdmin(username,password);
    }
    public Admin findByUsernameAndPassword(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username,password);
    }
    public List<Admin> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        return adminRepository.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }
    public Integer countByKeyword(String keyword) {
        return adminRepository.countByKeyword(keyword);
    }
    public Admin findById(Integer id) throws AdminNotFoundException {
        Admin admin = adminRepository.findById(id);
        if(admin == null){
            throw new AdminNotFoundException("Salary not found with id:" + id);
        }
        return admin;
    }
    public void save(Admin admin){
        if(admin.getId() == 0){
            adminRepository.add(admin);
        }
        else{
            adminRepository.update(admin);
        }
    }
    public void delete(Integer id) throws AdminNotFoundException {
        if(adminRepository.findById(id) == null){
            throw new AdminNotFoundException("Salary not found with id:" + id);
        }
        adminRepository.delete(id);
    }
}
