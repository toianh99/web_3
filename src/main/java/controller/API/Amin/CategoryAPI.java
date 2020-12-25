package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.CategoryService;
import controller.SHARE.HttpUtil;
import model.Category;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "CategoryAPI",urlPatterns = "/api-v1-category")
public class CategoryAPI extends HttpServlet {
     private  ObjectMapper mapper = new ObjectMapper();
     private  CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Category category = HttpUtil.of(request.getReader()).toModel(Category.class);
        List<Category> categories = categoryService.listCategoryByPage(0,100);
        mapper.writeValue(response.getOutputStream(),categories);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Category category = HttpUtil.of(request.getReader()).toModel(Category.class);
        categoryService.saveCategory(category);
        mapper.writeValue(response.getOutputStream(),category);
    }
    @Override
    protected void doPut(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UFT-8");
        response.setContentType("application/json");
        Category category = HttpUtil.of(request.getReader()).toModel(Category.class);
        categoryService.updateCategory(category);
        mapper.writeValue(response.getOutputStream(),category);

    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
        System.out.println(category.getIdCategory());
        categoryService.deleteCategory(category.getIdCategory());
//        userService.deleteUser(customer.getIdCustomer());
        mapper.writeValue(resp.getOutputStream(),"{Xoa thanh cong}");
    }

}
