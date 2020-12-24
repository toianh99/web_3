package controller.SERVICE;

import model.Shipaddress;

import java.util.List;

public interface IShipaddressService {
    int saveShipaddress(Shipaddress shipaddress);
    void updateShipaddress(Shipaddress shipaddress);
    void deleteShipaddress(int id);
    Shipaddress findById(int id);
    List<Shipaddress> getShipaddressBypage(int pagenum, int pagesize);
}
