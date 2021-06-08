package com.thien.dao;

import com.thien.model.Account;
import com.thien.model.Customer;
import com.thien.model.Service;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class AccountDao implements IAccountDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String SELECT_ACC = "SELECT username, password FROM account WHERE username = ? AND password = ?";
    private static final String SELECT_ACC_EXIST = "SELECT username FROM account WHERE username = ?";
    private static final String INSERT_ACC_SQL = "INSERT INTO account"+"(username,password,email) VALUES"+"(?,?,?);";
    private static final String SELECT_ALL_ACC = "SELECT c.customerNumber, c.fullName, c.address, s.description,e.name_emp,c.start_date ,c.total\n" +
            "FROM customers c\n" +
            "INNER JOIN services s\n" +
            "ON c.serviceCode = s.serviceCode\n" +
            "INNER JOIN employees e\n" +
            "ON c.id_emp = e.id_emp;";
    public AccountDao(){

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

    @Override
    public Account selectAccount(String user, String pass) {
        Account account = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACC);){
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                account = new Account(user,pass);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return account;
    }

    public Account selectExistAccount(String user) {
        Account account = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACC_EXIST);){
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
    public void insertAccount(Account account) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACC_SQL);){
            preparedStatement.setString(1,account.getUser());
            preparedStatement.setString(2,account.getPass());
            preparedStatement.setString(3,account.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public List<Customer> selectAllAccount() {
        List<Customer> listCustomer = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACC);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customerNumber");
                String name = rs.getString("fullName");
                String address = rs.getString("address");
                String des = rs.getString("description");
                String nameEmp = rs.getString("name_emp");
                Date startDate = rs.getDate("start_date");
                double total = rs.getDouble("total");
                listCustomer.add(new Customer(id,name,address,des,nameEmp,startDate,total));
            }
        }catch (SQLException e){
            printSQLException(e);

        }
        return listCustomer;
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
