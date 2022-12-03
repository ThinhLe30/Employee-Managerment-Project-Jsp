package com.ngthvu.quanlynhanvienproject.repository;

import com.ngthvu.quanlynhanvienproject.entity.Department;
import com.ngthvu.quanlynhanvienproject.entity.Employee;
import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.util.DbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DepartmentRepository {
    // represent DAO, contact with database in MySql,return Entity or List of Entity
    // do not contact from Controller to Repository
    // have to go through Service to Repository
    private DbHelper dbHelper;
    private static final String GET_ALL_DEPARTMENTS = "select * from departments order by name asc";
    private static final String GET_DEPARTMENT = "select * from departments where key = ?";
    private static final String INSERT_DEPARTMENT = "insert into departments (name, address, phone_number, description) " +
            "values (?,?,?,?)";
    private static final String UPDATE_DEPARTMENT = "update departments set name = ?, address = ?, phone_number = ?" +
            ", description = ? where id = ?";
    private static final String DELETE_DEPARTMENT = "delete from departments where id = ?";
    private static final String SEARCH_DEPARTMENT = "select * from departments where concat(name, ' ', address, ' ', phone_number, ' ', description) like ?";
    private static final String COUNT_BY_KEYWORD = "select count(*) as count from departments " +
            "where concat(name, ' ', address, ' ', phone_number, ' ', description) " +
            "like concat( '%',?,'%')";
    private static final String LIST_BY_PAGE = "select * from departments " +
            "where concat(name, ' ', address, ' ', phone_number, ' ', description) " +
            "like concat( '%',?,'%')";

    public DepartmentRepository() {
        dbHelper = new DbHelper();
    }
    public List<Department> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        List<Department> departments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(LIST_BY_PAGE + " order by "+fieldName+" "+orderBy+" limit ?,?");
            preparedStatement.setString(1,keyword);
            preparedStatement.setInt(2,start-1);
            preparedStatement.setInt(3,numberPerPage);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                departments.add(
                        new Department(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getString("phone_number"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
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
    public ArrayList<Department> getAll() {
        ArrayList<Department> departments = new ArrayList<>();
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_ALL_DEPARTMENTS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                departments.add(
                        new Department(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getString("phone_number"),
                                rs.getString("description")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public Department get(Integer id) {
        Department department = null;
        try {
            String GET_DEPARTMENT_ID = GET_DEPARTMENT.replace("key", "id");
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_DEPARTMENT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department = new Department(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    public Department get(String type, String value) {
        Department department = null;
        String GET_DEPARTMENT_TYPE = GET_DEPARTMENT.replace("key", type);
        System.out.println(GET_DEPARTMENT_TYPE);
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(GET_DEPARTMENT_TYPE);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department = new Department(rs.getInt("id"),rs.getString("name")
                        ,rs.getString("address"),
                        rs.getString("phone_number"),rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

//    private void setDepartment(Department department, PreparedStatement ps) throws SQLException {
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            department = new Department(rs.getInt("id"),rs.getString("name")
//                    ,rs.getString("address"),
//                    rs.getString("phone_number"),rs.getString("description"));
//        }
//    }

    public void add(Department department) throws Exception {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(INSERT_DEPARTMENT);
            ps.setString(1, department.getName());
            ps.setString(2, department.getAddress());
            ps.setString(3, department.getPhone_number());
            ps.setString(4, department.getDescription());
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to add department! Try again.");
        }
    }

    public void update(Department department) throws Exception {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(UPDATE_DEPARTMENT);
            ps.setString(1, department.getName());
            ps.setString(2, department.getAddress());
            ps.setString(3, department.getPhone_number());
            ps.setString(4, department.getDescription());
            ps.setInt(5, department.getId());
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to update department! Try again.");
        }
    }

    public void delete(Integer id) throws Exception {
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(DELETE_DEPARTMENT);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to delete department! Try again.");
        }
    }

    public ArrayList<Department> search(String keyword) {
        ArrayList<Department> departments = new ArrayList<>();
        try {
            PreparedStatement ps = dbHelper.getConnection().prepareStatement(SEARCH_DEPARTMENT);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                departments.add(
                        new Department(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getString("phone_number"),
                                rs.getString("description")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

}
