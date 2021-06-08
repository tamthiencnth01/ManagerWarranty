package com.thien.dao;

import com.thien.model.Product;
import com.thien.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    private static final String INSERT_PRODUCT = "INSERT INTO products (name_product, price, image) VALUES (?,?,?);";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM products";
    public ProductDao() {
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

    public void insertProduct(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);){
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getImage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public List<Product> selectAllProduct() {
        List<Product> list = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_product");
                String nameProduct = rs.getString("name_product");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                list.add(new Product(id,nameProduct,price,image));
            }
        }catch (SQLException e){
            printSQLException(e);
        }return list;
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
