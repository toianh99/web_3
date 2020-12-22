package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryMapper implements RowMapper<Inventory> {
    @Override
    public Inventory mapRow(ResultSet rs) throws SQLException {
        try{
            Inventory inventory = new Inventory(rs.getString("NameProduct"),rs.getString("Staff"),rs.getInt("Quantity"),rs.getInt("PriceIn"));
            return inventory;
        }catch (Exception ex){
            System.out.println("lỗi mapper inventory");
        }
        return null;
    }
}
