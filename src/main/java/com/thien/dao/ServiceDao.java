package com.thien.dao;

import com.thien.model.Customer;
import com.thien.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String SELECT_SERVICE_BY_ID = "SELECT description, units, quantities, unitPrice, amout FROM services WHERE serviceCode = ?;";
    private static final String INSERT_SERVICE_SQL = "INSERT INTO services"+"(description,units, quantities, unitPrice, amout) VALUES"+"(?,?,?,?,?);";
    private static final String SELECT_SERVICE_ALL = "SELECT * FROM services";
    private static final String DELETE_SERVICE = "DELETE FROM services WHERE serviceCode = ?;";
    private static final String UPDATE_SERVICE = "UPDATE services \n" +
            "SET description = ?, units= ? , quantities = ?, unitPrice = ?, amout = ? \n" +
            "WHERE serviceCode = ?; ";
    private static final String SEARCH_LIKE = "select * from services where description like ?;";

    public ServiceDao(){

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
    public List<Service> searchLike(String keyWord) {
        List<Service> list = new ArrayList<>();
        keyWord = "%"+keyWord+"%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_LIKE);) {
            preparedStatement.setString(1,keyWord);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("serviceCode");
                String description = rs.getString("description");
                String units = rs.getString("units");
                int quantities = rs.getInt("quantities");
                double price = rs.getDouble("unitPrice");
                double amount = rs.getDouble("amout");
                list.add(new Service(id,description,units,quantities,price,amount));
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }return list;
    }
    public Service selectService(int id) {
        Service service = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String description = rs.getString("description");
                String units = rs.getString("units");
                int quantities = Integer.parseInt(rs.getString("quantities"));
                double unitPrice = Double.parseDouble(rs.getString("unitPrice"));
                double amout = Double.parseDouble(rs.getString("amout"));
                service = new Service(id,description,units,quantities,unitPrice,amout);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return service;
    }
    @Override
    public void insertService(Service service) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL);){
            preparedStatement.setString(1,service.getDescription());
            preparedStatement.setString(2,service.getUnits());
            preparedStatement.setInt(3,service.getQuantities());
            preparedStatement.setDouble(4,service.getUnitPrice());
            preparedStatement.setDouble(5,service.getAmount());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> list = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_ALL);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("serviceCode");
                String description = rs.getString("description");
                String units = rs.getString("units");
                int quantities = rs.getInt("quantities");
                double price = rs.getDouble("unitPrice");
                double amount = rs.getDouble("amout");
                list.add(new Service(id,description,units,quantities,price,amount));
            }
        }catch (SQLException e){
            printSQLException(e);
        }return list;
    }


    @Override
    public boolean deleteService(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE);){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate()>0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE);){
            preparedStatement.setString(1,service.getDescription());
            preparedStatement.setString(2,service.getUnits());
            preparedStatement.setInt(3,service.getQuantities());
            preparedStatement.setDouble(4,service.getUnitPrice());
            preparedStatement.setDouble(5,service.getAmount());
            preparedStatement.setInt(6,service.getId());
            rowUpdate = preparedStatement.executeUpdate()>0;
        }
        return rowUpdate;
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
