package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.BrandService;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        Brand brand = HttpUtil.of(request.getReader()).toModel(Brand.class);
         brandService.saveBrand(brand);
        mapper.writeValue(response.getOutputStream(),brand);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        if(id!=null){
            Brand brand = brandService.findBrandById(Integer.parseInt(id));
            mapper.writeValue(response.getOutputStream(),brand);
        }else{
            List<Brand> brands = brandService.getBrandByPage(0,100);
            mapper.writeValue(response.getOutputStream(),brands);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        Brand brand = HttpUtil.of(req.getReader()).toModel(Brand.class);
        brandService.updateBrand(brand);
        mapper.writeValue(resp.getOutputStream(),brand);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        Brand brand = HttpUtil.of(req.getReader()).toModel(Brand.class);
        brandService.deleteBrand(brand.getIdBrand());
        mapper.writeValue((resp.getOutputStream()),"xóa thành công");
    }
}
