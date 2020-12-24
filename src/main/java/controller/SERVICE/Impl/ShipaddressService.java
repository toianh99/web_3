package controller.SERVICE.Impl;

import controller.DAO.Impl.ShipaddressDAOImpl;
import controller.SERVICE.IShipaddressService;
import model.Shipaddress;

import java.util.List;

public class ShipaddressService implements IShipaddressService {
    private ShipaddressDAOImpl shipaddressDAO = new ShipaddressDAOImpl();
    @Override
    public int saveShipaddress(Shipaddress shipaddress) {
        return shipaddressDAO.saveShipaddress(shipaddress);
    }

    @Override
    public void updateShipaddress(Shipaddress shipaddress) {
        shipaddressDAO.updateShipaddress(shipaddress);
    }

    @Override
    public void deleteShipaddress(int id) {
        shipaddressDAO.deleteShipaddress(id);
    }

    @Override
    public Shipaddress findById(int id) {
        return shipaddressDAO.findById(id);
    }

    @Override
    public List<Shipaddress> getShipaddressBypage(int pagenum, int pagesize) {
        return shipaddressDAO.getShipaddressBypage(pagenum, pagesize);
    }
}
