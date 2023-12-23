package com.example.layeredarchitecture.Dao.customeImp;
import com.example.layeredarchitecture.Dao.placeorderinterface;
import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class placeorderInterfaceImp implements placeorderinterface {


       // public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
          /*  Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            stm.setString(1, dto.getOid());
            stm.setString(2, dto.getItemCode());
            stm.setBigDecimal(3, dto.getUnitPrice());
            stm.setInt(4, dto.getQty());
            return stm.executeUpdate()>0;*/
           // return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
       public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
           return null;
       }

    @Override
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", dto.getOid(), dto.getItemCode(), dto.getUnitPrice(), dto.getQty());
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public OrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
        }
    }

