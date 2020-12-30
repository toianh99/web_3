package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.SaleService;
import controller.SHARE.HttpUtil;
import model.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SaleAPI", urlPatterns = {"/api-v1-sale"})
public class SaleAPI extends HttpServlet {
    private SaleService saleService = new SaleService();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<Sale> sales = saleService.getSalePage(0,100);
        mapper.writeValue(resp.getOutputStream(),sales);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Sale sale = HttpUtil.of(req.getReader()).toModel(Sale.class);
        saleService.saveSale(sale);
        mapper.writeValue(resp.getOutputStream(),sale);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Sale sale = HttpUtil.of(req.getReader()).toModel(Sale.class);
        saleService.updateSale(sale);
        mapper.writeValue(resp.getOutputStream(),sale);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Sale sale = HttpUtil.of(req.getReader()).toModel(Sale.class);
        saleService.deleteSale(sale.getIdSale());
        mapper.writeValue(resp.getOutputStream(),sale);
    }
}
