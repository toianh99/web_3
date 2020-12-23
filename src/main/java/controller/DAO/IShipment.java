package controller.DAO;

import model.Shipment;

import java.util.List;

public interface IShipment extends IBaseDAO<Shipment> {
    int saveShipment(Shipment shipment);
    void updateShipment(Shipment shipment);
    void deleteShipment(int id);
    Shipment findShipmentById(int id);
    List<Shipment> findShipmentByPage(int pagenum,int pagesize);
}
