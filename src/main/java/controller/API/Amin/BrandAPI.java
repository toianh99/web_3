package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.IBrandService;
import controller.SERVICE.Impl.BrandService;
import controller.SERVICE.Impl.CustomerService;
import controller.SERVICE.Impl.UserService;
import controller.SHARE.HttpUtil;
import model.Brand;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BrandAPI",urlPatterns = {"/api-v1-brand"})
public class BrandAPI extends HttpServlet {


    private ObjectMapper mapper = new ObjectMapper();
    private BrandService brandService = new BrandService();
    //private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
//        int id;
//        List<Brand> brands = brandService.findBrandById(id);
//        mapper.writeValue(resp.getOutputStream(), brands);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Brand brand= HttpUtil.of(req.getReader()).toModel(Brand.class);
        brandService.saveBrand(brand);

        mapper.writeValue(resp.getOutputStream(), brand);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Brand brand= HttpUtil.of(req.getReader()).toModel(Brand.class);
        brandService.updateBrand(brand);

        mapper.writeValue(resp.getOutputStream(), brand);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Brand brand = HttpUtil.of(req.getReader()).toModel(Brand.class);
        System.out.println(brand.getIdBrand());
        brandService.deleteBrand(brand.getIdBrand());
        //userService.deleteUser(customer.getIdCustomer());
        mapper.writeValue(resp.getOutputStream(), "{Xoa thanh cong}");
    }
}

