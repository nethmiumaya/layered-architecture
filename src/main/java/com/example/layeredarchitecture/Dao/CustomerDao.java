package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDao {
    public ArrayList<CustomerDTO> getAllCustomer()throws SQLException,ClassNotFoundException;
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDTO dto)throws SQLException,ClassNotFoundException;

    public boolean existcustomer(String id)throws SQLException,ClassNotFoundException;

    public boolean deletecustomer(String id)throws SQLException,ClassNotFoundException;
    public ResultSet generateNewId() throws SQLException, ClassNotFoundException;
}
