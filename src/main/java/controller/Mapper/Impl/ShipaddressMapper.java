package controller.Mapper.Impl;


import controller.Mapper.RowMapper;
import model.Shipaddress;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShipaddressMapper implements RowMapper<Shipaddress> {
    @Override
    public Shipaddress mapRow(ResultSet rs) throws SQLException {
        try{
            Shipaddress shipaddress = new Shipaddress(rs.getInt("ID"),rs.getString("Province"),rs.getString("Commune"),rs.getString("Dictrict"),rs.getString("Detail"));
            return shipaddress;
        }catch (Exception ex){
            System.out.println("lối mapper shippaddress");
        }
        return null;
    }
}
