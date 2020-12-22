package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Province;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs) throws SQLException {
        try {
            Province province = new Province();
            province.setMatp(rs.getString("matp"));
            province.setNameProvince(rs.getString("NameProvince"));
            province.setType(rs.getString("type"));
            return province;
        }catch (Exception e){
            System.out.println("lỗi mapper province");
        }
        return null;
    }
}
