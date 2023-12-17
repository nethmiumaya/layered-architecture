package com.example.layeredarchitecture.Dao;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class placeorderInterfaceImp implements placeorderinterface {

        @Override
        public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            stm.setString(1, dto.getOid());
            stm.setString(2, dto.getItemCode());
            stm.setBigDecimal(3, dto.getUnitPrice());
            stm.setInt(4, dto.getQty());
            return stm.executeUpdate()>0;
        }
    }
