package com.ngthvu.quanlynhanvienproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private Connection connection;
    public DbHelper(){
        this.connection = null;
    }

    private static String jdbcURL = "jdbc:mysql://localhost:3306/employee_management?allowPublicKeyRetrieval=true&useSSL=false";
    private static String jdbcUsername = "hbstudent"; // username of database go here
    private static String jdbcPassword = "hbstudent"; // password of database go here
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
