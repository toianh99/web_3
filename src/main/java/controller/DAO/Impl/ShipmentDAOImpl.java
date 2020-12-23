package controller.DAO.Impl;

import controller.DAO.IShipment;
import controller.Mapper.Impl.ShipmentMapper;
import model.Shipment;

import java.util.List;

public class ShipmentDAOImpl extends BaseDAOImpl<Shipment> implements IShipment {
    @Override
    public int saveShipment(Shipment shipment) {
        StringBuilder sql = new StringBuilder("INSERT INTO `shipment` ( `NameShip`,`Type`)");
        sql.append("VALUES( ?,?)");
        return insert(sql.toString(),shipment.getNameShipment(),shipment.getTypeShip());
    }

    @Override
    public void updateShipment(Shipment shipment) {
        String sql = "UPDATE `shipment` SET `NameShip` = ? , `Type` =? WHERE `ID`=?";
        update(sql,shipment.getNameShipment(),shipment.getTypeShip(),shipment.getIdShipment());
    }

    @Override
    public void deleteShipment(int id) {
        String sql = "DELETE * FROM `shipment` WHERE `ID`=?";
        update(sql,id);
    }

    @Override
    public Shipment findShipmentById(int id) {
        String sql="SELECT * FROM `shipment` WHERE `ID`=?";
        return query(sql,new ShipmentMapper(),id).get(0);
    }

    @Override
    public List<Shipment> findShipmentByPage(int pagenum, int pagesize) {
        String sql ="SELECT * FROM `shipment` LIMIT ?,?";
        return query(sql,new ShipmentMapper(),pagenum,pagesize);
    }
}
