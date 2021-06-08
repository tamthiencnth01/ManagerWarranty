package com.thien.dao;

import com.thien.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDao {
    public void insertService(Service service) throws SQLException;
    public List<Service> selectAllService();
    public Service selectService(int id);
    public boolean deleteService(int id) throws SQLException;
    public boolean updateService(Service service) throws SQLException;
}
