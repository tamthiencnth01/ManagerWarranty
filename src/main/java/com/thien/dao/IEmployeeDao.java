package com.thien.dao;

import com.thien.model.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDao {
    public void insertEmp(String name, String address, String dob, String gender, String nation,
                          String phone,String image) throws SQLException;
    public List<Employee> selectAllEmp() throws IOException, SQLException;
    public Employee selectEmpById(int id);
    public boolean deleteEmp(int id) throws SQLException;
}
