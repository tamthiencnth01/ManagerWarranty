package com.thien.dao;

import com.thien.model.Account;
import com.thien.model.Customer;
import com.thien.model.Employee;
import com.thien.model.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class EmployeeDao implements IEmployeeDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String SELECT_EMP_BY_ID = "SELECT * FROM employees WHERE id_emp = ?;";
    private static final String SELECT_EMP_EXIST = "SELECT username FROM account WHERE username = ?";
    private static final String INSERT_EMP_SQL = "INSERT INTO employees (name_emp, address, date_of_birth, gender, nation, phone, img) VALUES(?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_EMP = "SELECT * FROM casestudy.employees;";
    private static final String UPDATE_EMP = "UPDATE employees \n" +
            "SET name_emp = ?,\n" +
            "address = ?,\n" +
            "date_of_birth = ?,\n" +
            "gender = ?,\n" +
            "nation = ?,\n" +
            "phone = ?,\n" +
            "img = ?\n" +
            "WHERE id_emp = ?;";
    private static final String DELETE_EMP = "DELETE FROM employees WHERE id_emp = ?;";

    public EmployeeDao(){

    }
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Account selectExistAccount(String user) {
        Account account = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMP_EXIST);){
            preparedStatement.setString(1,user);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                account = new Account(user);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return account;
    }

    @Override
    public void insertEmp(String name, String address, String dob, String gender, String nation,
                          String phone,String image) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMP_SQL);){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,dob);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,nation);
            preparedStatement.setString(6,phone);
            preparedStatement.setString(7,image);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public List<Employee> selectAllEmp() throws IOException, SQLException {
        List<Employee> list = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMP);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_emp");
                String name = rs.getString("name_emp");
                String address = rs.getString("address");
                Date dob = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String nation = rs.getString("nation");
                String phone = rs.getString("phone");
                String image = rs.getString("img");

                list.add(new Employee(id,name,address,dob,gender,nation,phone,image));
            }
        }catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    @Override
    public Employee selectEmpById(int id) {
        Employee employee = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMP_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name_emp");
                String address = rs.getString("address");
                Date dob = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String nation = rs.getString("nation");
                String phone = rs.getString("phone");
                String image = rs.getString("img");
                employee = new Employee(id,name,address,dob,gender,nation,phone,image);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return employee;
    }

    public boolean updateEmp(String name, String address, String dob, String gender, String nation,
                             String phone,String image, int id) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMP);){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,dob);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,nation);
            preparedStatement.setString(6,phone);
            preparedStatement.setString(7,image);
            preparedStatement.setInt(8,id);
            rowUpdate = preparedStatement.executeUpdate()>0;
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteEmp(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMP);){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate()>0;
        }
        return rowDelete;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
