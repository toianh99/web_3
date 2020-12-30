package controller.Mapper.Impl;

import java.sql.ResultSet;
import controller.Mapper.RowMapper;
import model.Brand;

public class BrandMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet rs) {
        try {
            Brand brand = new Brand();
            brand.setIdBrand(rs.getInt("ID"));
            brand.setNameBrand(rs.getString("Name"));
           brand.setDesc(rs.getString("Desc"));
           brand.setCodeBrand(rs.getString("Code"));
            return brand;
        }catch (Exception e){
            System.out.println("lỗi mapper brand");
        }
        return null;
    }
}
