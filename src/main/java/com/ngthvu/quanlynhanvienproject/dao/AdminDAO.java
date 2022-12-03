package com.ngthvu.quanlynhanvienproject.dao;

import com.ngthvu.quanlynhanvienproject.bean.Admin;
import com.ngthvu.quanlynhanvienproject.util.DbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    // represent DAO, contact with database in MySql,return Entity or List of Entity
    // do not contact from Controller to Repository
    // have to go through Service to Repository
    private DbHelper dbHelper;
    private static final String COUNT_ADMIN_BY_USERNAME_PASSWORD = "select count(*) as count from employee_management.admin " +
            "where username = ? and password = ?";
    private static final String FIND_BY_USERNAME_PASSWORD = "select * from employee_management.admin " +
            "where username = ? and password = ? limit 1";
    private static final String LIST_BY_PAGE =
            "select * from employee_management.admin" +
                    " where concat(username, '' , first_name, ' ', last_name, ' ', phone)" +
                    " like concat( '%',?,'%')";
    private static final String COUNT_BY_KEYWORD =
            "select count(*) as count  from employee_management.admin" +
                    " where concat(username, '' , first_name, ' ', last_name, ' ', phone)" +
                    " like concat( '%',?,'%')";
    private static final String  FIND_BY_ID =
            "select * from employee_management.admin" +
                    " where id = ?";
    private static final String  INSERT =
            "insert into employee_management.admin" +
                    " (username,password,first_name,last_name,phone)" +
                    " values (?,?,?,?,?)";
    private static final String  UPDATE =
            "update employee_management.admin" +
                    " set username = ?, password = ?, first_name = ?, last_name = ?, phone = ?" +
                    " where id = ?";
    private static final String  DELETE =
            "delete from employee_management.admin " +
                    "where id = ?";

    public AdminDAO(){
        dbHelper = new DbHelper();
    }
    public boolean isValidAdmin(String username, String password){
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(COUNT_ADMIN_BY_USERNAME_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer count = rs.getInt("count");
                if(count != 1) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public Admin findByUsernameAndPassword(String username, String password){
        Admin admin = null;
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(FIND_BY_USERNAME_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                admin = new Admin(id,username,password,firstName,lastName,phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    public List<Admin> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        List<Admin> admins = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(LIST_BY_PAGE + " order by "+fieldName+" "+orderBy+" limit ?,?");
            preparedStatement.setString(1,keyword);
            preparedStatement.setInt(2,start-1);
            preparedStatement.setInt(3,numberPerPage);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                admins.add(new Admin(id,username,password,firstName,lastName,phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }
    public Integer countByKeyword(String keyword) {
        Integer count = 0;
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(COUNT_BY_KEYWORD);
            preparedStatement.setString(1,keyword);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public Admin findById(Integer id){
        Admin admin = null;
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                admin = new Admin(id,username,password,firstName,lastName,phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    public void add(Admin admin){
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(INSERT);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getFirstName());
            preparedStatement.setString(4, admin.getLastName());
            preparedStatement.setString(5, admin.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Admin admin){
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getFirstName());
            preparedStatement.setString(4, admin.getLastName());
            preparedStatement.setString(5, admin.getPhone());
            preparedStatement.setInt(6,admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(Integer id){
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
