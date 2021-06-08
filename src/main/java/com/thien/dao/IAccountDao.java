package com.thien.dao;

import com.thien.model.Account;
import com.thien.model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public interface IAccountDao {
    public Account selectAccount(String user, String pass);
    public void insertAccount(Account account) throws SQLException;
    public List<Customer> selectAllAccount();
}
