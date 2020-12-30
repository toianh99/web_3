package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.ShipmentService;
import controller.SHARE.HttpUtil;
import model.Shipment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Shipment",urlPatterns = {"/api-v1-shipment"})
public class ShipmentAPI extends HttpServlet {
    private ShipmentService shipmentService = new ShipmentService();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<Shipment> shipments = shipmentService.findShipmentByPage(0,100);
        mapper.writeValue(resp.getOutputStream(),shipments);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Shipment shipment = HttpUtil.of(req.getReader()).toModel(Shipment.class);
        shipmentService.saveShipment(shipment);
        mapper.writeValue(resp.getOutputStream(),shipment);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Shipment shipment = HttpUtil.of(req.getReader()).toModel(Shipment.class);
        shipmentService.updateShipment(shipment);
        mapper.writeValue(resp.getOutputStream(),shipment);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Shipment shipment = HttpUtil.of(req.getReader()).toModel(Shipment.class);
        shipmentService.deleteShipment(shipment.getIdShipment());
        mapper.writeValue(resp.getOutputStream(),shipment);
    }
}
