package com.example.layeredarchitecture.Dao.customeImp;
import com.example.layeredarchitecture.Dao.placeorderinterface;
import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class placeorderInterfaceImp implements placeorderinterface {

        @Override
        public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
          /*  Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            stm.setString(1, dto.getOid());
            stm.setString(2, dto.getItemCode());
            stm.setBigDecimal(3, dto.getUnitPrice());
            stm.setInt(4, dto.getQty());
            return stm.executeUpdate()>0;*/
            return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
        }
    }

