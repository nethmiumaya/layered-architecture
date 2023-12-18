package com.example.layeredarchitecture.Dao;

import java.sql.SQLException;
import java.util.ArrayList;


    public interface CRUDDao<T> {
        ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
        boolean save(T dto) throws SQLException, ClassNotFoundException ;
        boolean update(T dto) throws SQLException, ClassNotFoundException ;
        boolean exist(String id) throws SQLException, ClassNotFoundException ;
        boolean delete(String id) throws SQLException, ClassNotFoundException ;
        String generateID() throws SQLException, ClassNotFoundException ;
        public T search(String id) throws SQLException, ClassNotFoundException;
    }

