package com.example.layeredarchitecture.Dao.customeImp;
import com.example.layeredarchitecture.Dao.placeOrderDao;
import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.model.OrderDTO;
import java.util.ArrayList;
import java.sql.*;
public class placeorderDaoImp implements placeOrderDao {


    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    /* public String generateOID() throws SQLException, ClassNotFoundException {
               /* Connection connection = DBConnection.getDbConnection().getConnection();
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
                return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";*/
          /*  ResultSet rst= SQLUtil.execute("SELECT oid FROM Orders ORDER BY oid DESC LIMIT 1");
            String id = rst.getString(1);
            int newCustomerId = Integer.parseInt(id.replace("O00-", "")) + 1;
            return String.format("O00-%03d", newCustomerId);

        }*/
        @Override
        public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
            return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),Date.valueOf(dto.getOrderDate()),dto.getCustomerId());
        }


       /* public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
           /* Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
            stm.setString(1, orderId);
            return stm.executeQuery().next();*/
           // ResultSet rst=SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
          /*  return rst.next();*/
    @Override
          public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
              return false;
        }

        @Override
       /* public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
          /*  Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
            stm.setString(1, dto.getOrderId());
            stm.setDate(2, Date.valueOf(dto.getOrderDate()));
            stm.setString(3, dto.getCustomerId());
            return stm.executeUpdate()>0;*/
       /*     return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());*/
        public boolean exist(String id) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",id);
            return rst.next();
        }
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean delete(String id) throws SQLException,ClassNotFoundException{
            return false;
    }

    @Override
    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
