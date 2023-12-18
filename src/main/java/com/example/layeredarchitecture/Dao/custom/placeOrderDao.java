package com.example.layeredarchitecture.Dao.custom;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
public interface placeOrderDao {
    public String generateOID() throws SQLException, ClassNotFoundException;
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}

