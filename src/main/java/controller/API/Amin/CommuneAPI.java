package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controller.SERVICE.Impl.CommuneService;
import controller.SHARE.HttpUtil;
import model.Commune;
import model.Dictrict;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CommuneAPI",urlPatterns = {"/api-v1-commune"})
public class CommuneAPI extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    private CommuneService communeService = new CommuneService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("application/json");
       Dictrict dictrict = HttpUtil.of(req.getReader()).toModel(Dictrict.class);
        List<Commune> communes = communeService.getCommuneByIdDictrict(dictrict.getMaqh());
        mapper.writeValue(resp.getOutputStream(),communes);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
