package controller.SERVICE.Impl;

import controller.DAO.Impl.CategoryDAOImpl;
import controller.SERVICE.ICategoryService;
import model.Category;

import java.awt.print.Pageable;
import java.util.List;

public class CategoryService implements ICategoryService {
    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    @Override
    public int saveCategory(Category category) {
        int a = categoryDAO.saveCategory(category);
        return a>0 ? a : 0;
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    public Category findCategoryById(int id) {
       return categoryDAO.findOne(id);
    }

    @Override
    public List<Category> listCategoryByPage(int pagenum, int pagesize) {
        return categoryDAO.findCategory(pagenum,pagesize);
    }
}
