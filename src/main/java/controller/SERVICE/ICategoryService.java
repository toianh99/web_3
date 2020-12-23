package controller.SERVICE;

import model.Category;

import java.awt.print.Pageable;
import java.util.List;

public interface ICategoryService {
    int saveCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category findCategoryById(int id);
    List<Category> listCategoryByPage(int pagenum, int pagesize);
}
