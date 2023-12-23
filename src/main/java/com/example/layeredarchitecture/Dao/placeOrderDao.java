package com.example.layeredarchitecture.Dao;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.Dao.CRUDDao;
import java.sql.SQLException;
/*public interface placeOrderDao {
    public String generateOID() throws SQLException, ClassNotFoundException;
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
*/
    public interface placeOrderDao extends CRUDDao<OrderDTO> {
}

