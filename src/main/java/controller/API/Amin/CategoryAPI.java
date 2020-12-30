package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.CategoryService;
import controller.SHARE.HttpUtil;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CategoryAPI",urlPatterns = {"/api-v1-category"})
public class CategoryAPI extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    private CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        if(id!=null){
           Category category= categoryService.findCategoryById(Integer.parseInt(id));
           mapper.writeValue(resp.getOutputStream(),category);
        }else{
            List<Category> categories = categoryService.listCategoryByPage(0,100);
            mapper.writeValue(resp.getOutputStream(),categories);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
        categoryService.saveCategory(category);
        mapper.writeValue(resp.getOutputStream(),category);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
        categoryService.updateCategory(category);
        mapper.writeValue(resp.getOutputStream(),category);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
        categoryService.deleteCategory(category.getIdCategory());
        mapper.writeValue(resp.getOutputStream(),category);
    }
}
