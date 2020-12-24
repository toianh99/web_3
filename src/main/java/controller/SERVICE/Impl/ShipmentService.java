package controller.SERVICE.Impl;

import controller.DAO.Impl.PaymentDAOImpl;
import controller.DAO.Impl.ShipmentDAOImpl;
import controller.SERVICE.IShipmentService;
import model.Shipment;

import java.util.List;

public class ShipmentService implements IShipmentService {
    private ShipmentDAOImpl shipmentDAO = new ShipmentDAOImpl();
    @Override
    public int saveShipment(Shipment shipment) {
        return shipmentDAO.saveShipment(shipment);
    }

    @Override
    public void updateShipment(Shipment shipment) {
        shipmentDAO.updateShipment(shipment);
    }

    @Override
    public void deleteShipment(int id) {
        shipmentDAO.deleteShipment(id);
    }

    @Override
    public Shipment findShipmentById(int id) {
        return shipmentDAO.findShipmentById(id);
    }

    @Override
    public List<Shipment> findShipmentByPage(int pagenum, int pagesize) {
        return shipmentDAO.findShipmentByPage(pagenum, pagesize);
    }
}
