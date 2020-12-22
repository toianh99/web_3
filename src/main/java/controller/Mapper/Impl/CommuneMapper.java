package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Commune;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommuneMapper implements RowMapper<Commune> {
    @Override
    public Commune mapRow(ResultSet rs) throws SQLException {
        try {
            Commune commune = new Commune();
            commune.setMaqh(rs.getString("maqh"));
            commune.setNameCommune(rs.getString("NameCommune"));
            commune.setType(rs.getString("type"));
            return commune;
        }catch (Exception e){
            System.out.println("lỗi mapper commune");
        }
        return null;
    }
}
