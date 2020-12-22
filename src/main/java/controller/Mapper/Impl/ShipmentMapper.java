package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Shipment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShipmentMapper implements RowMapper<Shipment> {
    @Override
    public Shipment mapRow(ResultSet rs) throws SQLException {
        try{
            Shipment shipment = new Shipment(rs.getInt("ID"),rs.getString("NameShip"),rs.getString("Type"));
            return shipment;
        }catch (Exception e){
            System.out.println("lỗi mapper Shipment");
        }
        return null;
    }
}
