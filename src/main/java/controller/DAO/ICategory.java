package controller.DAO;

import model.Category;

public interface ICategory extends IBaseDAO<Category> {
    int save(Category category);
    void update(Category category);
    void delete(int id);
    int getCount();
}
