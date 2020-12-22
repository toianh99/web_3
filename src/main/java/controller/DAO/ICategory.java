package controller.DAO;

import model.Category;

import java.util.List;

public interface ICategory extends IBaseDAO<Category> {
    int saveCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    int getCount();
    Category findOne(int id);
    Category findOneByCode(String code);
    List<Category> findCategory(int pagenum, int pagesize);
}
