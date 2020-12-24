package controller.SERVICE;

import model.Shipment;

import java.util.List;

public interface IShipmentService {
    int saveShipment(Shipment shipment);
    void updateShipment(Shipment shipment);
    void deleteShipment(int id);
    Shipment findShipmentById(int id);
    List<Shipment> findShipmentByPage(int pagenum, int pagesize);
}
