package controller.Mapper.Impl;



import controller.Mapper.RowMapper;
import model.Category;

import java.sql.ResultSet;

public class CategoryMapper  implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs) {
        try {
            Category category = new Category();
            category.setIdCategory(rs.getInt("ID"));
            category.setNameCategory(rs.getString("Name"));
            category.setCodeCategory(rs.getString("Code"));
            return category;
        }catch (Exception ce){
            System.out.println("lỗi mapper category");
        }
        return null;
    }
}
