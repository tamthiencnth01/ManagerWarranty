package com.thien.dao;

import com.thien.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDao {
    public void insertCustomer(Customer customer) throws SQLException;
    public List<Customer> selectAllCustomer();
    public Customer selectCustomer(int id);
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
}
