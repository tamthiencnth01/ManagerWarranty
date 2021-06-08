package com.thien.dao;

import com.thien.model.Customer;
import com.thien.model.Employee;
import com.thien.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    private static final String SELECT_ALL_SERVICE = "SELECT description from services;";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT name_emp from employees;";
    private static final String SEARCH_LIKE = "select * from customers where fullName like ? or address like ? or email like ?;";
    public CustomerDao(){

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
    public List<Customer> searchLike(String keyWord) {
        List<Customer> list = new ArrayList<>();
        keyWord = "%"+keyWord+"%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_LIKE);) {
            preparedStatement.setString(1,keyWord);
            preparedStatement.setString(2,keyWord);
            preparedStatement.setString(3,keyWord);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customerNumber");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                list.add(new Customer(id,fullName,address,email,phone));
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }return list;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        String query = "{CALL sp_insert_customer(?,?,?,?,?,?,?,?)}";
        try (Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1,customer.getId());
            callableStatement.setString(2,customer.getFullName());
            callableStatement.setString(3,customer.getAddress());
            callableStatement.setString(4,customer.getEmail());
            callableStatement.setString(5,customer.getPhone());
            callableStatement.setString(6,customer.getDescription());
            callableStatement.setString(7,customer.getNameEmp());
            callableStatement.setInt(8,customer.getQuantities());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> list = new ArrayList<>();
        String query = "{CALL sp_select_all_customer}";
        try (Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query);){
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customerNumber");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                list.add(new Customer(id,fullName,address,email,phone));
            }
        }catch (SQLException e){
            printSQLException(e);
        }return list;
    }
    public List<Service> selectAllServices() {
        List<Service> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_SERVICE);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String description = rs.getString("description");
                list.add(new Service(description));
            }
        }catch (SQLException e){
            printSQLException(e);
        }return list;
    }
    public List<Employee> selectAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_EMPLOYEE);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String fullName = rs.getString("name_emp");
                list.add(new Employee(fullName));
            }
        }catch (SQLException e){
            printSQLException(e);
        }return list;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        String query = "{CALL sp_select_by_id(?)}";
        try(Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1,id);
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("fullName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String description = rs.getString("description");
                String nameEmp = rs.getString("name_emp");
                customer = new Customer(id,name,address,email,phone,description,nameEmp);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        String query = "{CALL sp_delete_customer(?)}";
        try(Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1,id);
            rowDeleted = callableStatement.executeUpdate()>0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        String query = "{CALL sp_update_customer(?,?,?,?,?,?,?,?)}";
        try (Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1,customer.getId());
            callableStatement.setString(2,customer.getFullName());
            callableStatement.setString(3,customer.getAddress());
            callableStatement.setString(4,customer.getEmail());
            callableStatement.setString(5,customer.getPhone());
            callableStatement.setString(6,customer.getDescription());
            callableStatement.setString(7,customer.getNameEmp());
            callableStatement.setInt(8,customer.getQuantities());
            rowUpdated = callableStatement.executeUpdate()>0;
        }
        return rowUpdated;
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
