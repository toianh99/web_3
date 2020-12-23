package controller.DAO;

import model.Shipaddress;

import java.util.List;

public interface IShipaddress extends IBaseDAO<Shipaddress> {
    int saveShipaddress(Shipaddress shipaddress);
    void updateShipaddress(Shipaddress shipaddress);
    void deleteShipaddress(int id);
    Shipaddress findById(int id);
    List<Shipaddress> getShipaddressBypage(int pagenum,int pagesize);
}
