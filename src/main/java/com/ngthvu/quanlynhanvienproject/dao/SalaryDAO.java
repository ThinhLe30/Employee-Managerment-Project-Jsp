package com.ngthvu.quanlynhanvienproject.dao;

import com.ngthvu.quanlynhanvienproject.entity.Salary;
import com.ngthvu.quanlynhanvienproject.util.DbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO {
    // represent DAO, contact with database in MySql,return Entity or List of Entity
    // do not contact from Controller to Repository
    // have to go through Service to Repository
    private DbHelper dbHelper;
    public SalaryDAO(){
        dbHelper = new DbHelper();
    }
    private static final String FIND_ALL_SALARY_BY_PAGE =
            "select * from employee_management.level_salaries " +
                    "where concat(basic_salary, '' , coefficient_pay, ' ', coeficient_allowance) " +
                    "like concat( '%',?,'%')";
    private static final String FIND_ALL =
            "select * from employee_management.level_salaries order by basic_salary asc";
    private static final String  FIND_BY_ID =
            "select * from employee_management.level_salaries " +
                    "where id = ?";
    private static final String  INSERT =
            "insert into employee_management.level_salaries" +
            " (basic_salary,coefficient_pay,coeficient_allowance) " +
                    "values (?,?,?)";
    private static final String  UPDATE =
            "update employee_management.level_salaries" +
            " set basic_salary = ?, coefficient_pay = ?, coeficient_allowance = ? " +
                    "where id = ?";
    private static final String  DELETE =
            "delete from employee_management.level_salaries " +
                    "where id = ?";
    private static final String SEARCH =
            "select * from employee_management.level_salaries where" +
            " concat(basic_salary, ' ', coefficient_pay, ' ',coeficient_allowance) " +
                    "like concat('%',?,'%')";
    private static final String COUNT_BY_KEYWORD =
            "select count(*) as count from employee_management.level_salaries where" +
            " concat(basic_salary, ' ', coefficient_pay, ' ',coeficient_allowance) " +
                    "like concat('%',?,'%')";
    public List<Salary> listByPage(Integer start, Integer numberPerPage, String keyword, String fieldName, String orderBy){
        List<Salary> salaries = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(FIND_ALL_SALARY_BY_PAGE + " order by "+fieldName+" "+orderBy+" limit ?,?");
            preparedStatement.setString(1,keyword);
            preparedStatement.setInt(2,start-1);
            preparedStatement.setInt(3,numberPerPage);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Float basic_salary = rs.getFloat("basic_salary");
                Float coefficient_pay = rs.getFloat("coefficient_pay");
                Float coeficient_allowance = rs.getFloat("coeficient_allowance");
                salaries.add(new Salary(id,basic_salary,coefficient_pay,coeficient_allowance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaries;
    }
    public ArrayList<Salary> findAll(){
        ArrayList<Salary> salaries = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Float basic_salary = rs.getFloat("basic_salary");
                Float coefficient_pay = rs.getFloat("coefficient_pay");
                Float coeficient_allowance = rs.getFloat("coeficient_allowance");
                salaries.add(new Salary(id,basic_salary,coefficient_pay,coeficient_allowance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaries;
    }
    public List<Salary> search(String keyword){
        List<Salary> salaries = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(SEARCH);
            preparedStatement.setString(1,keyword);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Float basic_salary = rs.getFloat("basic_salary");
                Float coefficient_pay = rs.getFloat("coefficient_pay");
                Float coeficient_allowance = rs.getFloat("coeficient_allowance");
                salaries.add(new Salary(id,basic_salary,coefficient_pay,coeficient_allowance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaries;
    }
    public Salary findById(Integer id){
        Salary salary = null;
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Float basic_salary = rs.getFloat("basic_salary");
                Float coefficient_pay = rs.getFloat("coefficient_pay");
                Float coeficient_allowance = rs.getFloat("coeficient_allowance");
                salary = new Salary(id,basic_salary,coefficient_pay,coeficient_allowance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salary;
    }
    public void add(Salary salary){
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(INSERT);
            preparedStatement.setFloat(1, salary.getBasicSalary());
            preparedStatement.setFloat(2, salary.getCoefficientPay());
            preparedStatement.setFloat(3, salary.getCoeficientAllowance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Salary salary){
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement(UPDATE);
            preparedStatement.setFloat(1, salary.getBasicSalary());
            preparedStatement.setFloat(2, salary.getCoefficientPay());
            preparedStatement.setFloat(3, salary.getCoeficientAllowance());
            preparedStatement.setInt(4, salary.getId());
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
}
