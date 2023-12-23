package com.example.layeredarchitecture.Dao.customeImp;

import com.example.layeredarchitecture.Dao.CustomerDao;
import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class ManageCustomerDaoImp implements CustomerDao {

    public ManageCustomerDaoImp() throws SQLException, ClassNotFoundException {
    }
@Override
    public ArrayList<CustomerDTO>getAll()throws SQLException,ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allcustomer = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allcustomer.add(customerDTO);
        }
        return allcustomer;
    }
    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        return pstm.executeUpdate() > 0;*/

       return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
    }
    @Override
public boolean update(CustomerDTO dto)throws SQLException,ClassNotFoundException{
    /*Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
    pstm.setString(1, dto.getId());
    pstm.setString(2, dto.getName());
    pstm.setString(3, dto.getAddress());
   return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getId(),dto.getName(),dto.getAddress());
    }
@Override
    public boolean exist(String id)throws SQLException,ClassNotFoundException{
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();*/
    ResultSet rst= SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
    return rst.next();
    }
@Override
    public boolean delete(String id)throws SQLException,ClassNotFoundException{
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        boolean isDeleted = pstm.executeUpdate()>0;
        return isDeleted;*/
   return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }
    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        String id = rst.getString(1);
        return id;
    }
    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, id + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));*/
        ResultSet rst=SQLUtil.execute("SELECT * FROM Customer WHERE id=?");
         rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }
}
