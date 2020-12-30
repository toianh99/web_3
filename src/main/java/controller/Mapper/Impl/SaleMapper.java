package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements RowMapper<Sale> {
    @Override
    public Sale mapRow(ResultSet rs) throws SQLException {
        try {
            Sale sale = new Sale();
            sale.setDesc(rs.getString("Desc"));
            sale.setNameSale(rs.getString("Name"));
            sale.setPercent(rs.getInt("Percent"));
            return sale;
        }catch (Exception e){
            System.out.println("lỗi mapper sale");
        }
        return null;
    }

}
