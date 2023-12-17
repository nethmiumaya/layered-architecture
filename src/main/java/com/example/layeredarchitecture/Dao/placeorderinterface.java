package com.example.layeredarchitecture.Dao;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;


public interface placeorderinterface {
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}