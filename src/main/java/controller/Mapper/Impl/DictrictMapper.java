package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Brand;
import model.Dictrict;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DictrictMapper implements RowMapper<Dictrict> {
    @Override
    public Dictrict mapRow(ResultSet rs) throws SQLException {

        try {
            try {
                Dictrict dictrict = new Dictrict();
                dictrict.setMaqh(rs.getString("maqh"));
                dictrict.setNameDictrict(rs.getString("NameDictrict"));
                dictrict.setMatp(rs.getString("matp"));
                dictrict.setType(rs.getString("type"));
            }catch (Exception e){
                System.out.println("lỗi mapper dictrict");
            }
            return null;
        }catch (Exception e){
            System.out.println("lỗi mapper brand");
        }
        return null;
    }
}
