package com.ngthvu.quanlynhanvienproject.bo;

import com.ngthvu.quanlynhanvienproject.entity.Admin;
import com.ngthvu.quanlynhanvienproject.exception.AdminNotFoundException;
import com.ngthvu.quanlynhanvienproject.dao.AdminDAO;

import java.util.List;

public class AdminBO {
    // represent BO, contact with controller and Repository
    private AdminDAO adminDAO;
    public AdminBO(){
        adminDAO = new AdminDAO();
    }
    public boolean isValidAdmin(String username, String password){
        return adminDAO.isValidAdmin(username,password);
    }
    public Admin findByUsernameAndPassword(String username, String password) {
        return adminDAO.findByUsernameAndPassword(username,password);
    }
    public List<Admin> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        return adminDAO.listByPage(start,numberPerPage,keyword,fieldName,orderBy);
    }
    public Integer countByKeyword(String keyword) {
        return adminDAO.countByKeyword(keyword);
    }
    public Admin findById(Integer id) throws AdminNotFoundException {
        Admin admin = adminDAO.findById(id);
        if(admin == null){
            throw new AdminNotFoundException("Salary not found with id:" + id);
        }
        return admin;
    }
    public void save(Admin admin){
        if(admin.getId() == 0){
            adminDAO.add(admin);
        }
        else{
            adminDAO.update(admin);
        }
    }
    public void delete(Integer id) throws AdminNotFoundException {
        if(adminDAO.findById(id) == null){
            throw new AdminNotFoundException("Salary not found with id:" + id);
        }
        adminDAO.delete(id);
    }
}
