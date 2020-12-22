package controller.DAO.Impl;


import controller.DAO.ICategory;
import controller.Mapper.Impl.CategoryMapper;
import model.Category;

import java.util.List;

public class CategoryDAOImpl extends BaseDAOImpl<Category> implements ICategory {

    @Override
    public List<Category> findCategory(int pagenum, int pagesize) {
        String sql = "SELECT * FROM category LIMIT ?,?";
        return query(sql, new CategoryMapper(),pagenum,pagesize);
    }

    @Override
    public Category findOne(int id) {
        String sql = "SELECT * FROM category WHERE ID = ?";
        List<Category> category = query(sql, new CategoryMapper(), id);
        return category.isEmpty() ? null : category.get(0);
    }

    @Override
    public Category findOneByCode(String code) {
        String sql = "SELECT * FROM category WHERE Name = ?";
        List<Category> category = query(sql, new CategoryMapper(), code);
        return category.isEmpty() ? null : category.get(0);
    }

    @Override
    public int saveCategory(Category category) {
        StringBuilder sql = new StringBuilder("INSERT INTO category (Name, Code)");
        sql.append(" VALUES(?, ?)");
        return insert(sql.toString(),category.getNameCategory(),category.getCodeCategory());
    }

    @Override
    public void deleteCategory(int id) {
        String sql = "DELETE FROM category WHERE ID = ?";
        update(sql, id);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void updateCategory(Category category) {
        StringBuilder sql = new StringBuilder("UPDATE category SET Name = ?, Code = ? WHERE ID = ?");
        update(sql.toString(), category.getNameCategory(),category.getCodeCategory(),category.getIdCategory());
    }
}
