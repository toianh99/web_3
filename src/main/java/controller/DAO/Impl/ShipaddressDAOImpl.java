package controller.DAO.Impl;

import controller.DAO.IShipaddress;
import controller.Mapper.Impl.ShipaddressMapper;
import model.Shipaddress;

import java.util.List;

public class ShipaddressDAOImpl extends BaseDAOImpl<Shipaddress> implements IShipaddress {
    @Override
    public int saveShipaddress(Shipaddress shipaddress) {
        StringBuilder sql = new StringBuilder("INSERT INTO `shipaddress`( `Province`,`Commune`,`Dictrict`,`Detail` )");
        sql.append("VALUES ( ?,?,?,?)");
        return insert(sql.toString(),shipaddress.getProvince(),shipaddress.getCommune(),shipaddress.getDictrict(),shipaddress.getDetail());
    }

    @Override
    public void updateShipaddress(Shipaddress shipaddress) {
        String sql ="UPDATE `shippaddress` SET `Province`=? , `Commune` =? , `Dictrict` = ? ,`Detail` = ? WHERE `ID` =?";
        update(sql,shipaddress.getProvince(),shipaddress.getCommune(),shipaddress.getDictrict(),shipaddress.getDetail(),shipaddress.getIdAddress());
    }

    @Override
    public void deleteShipaddress(int id) {
        String sql = "DELETE * FROM `shipaddress` WHERE `ID` = ? ";
        update(sql,id);
    }

    @Override
    public Shipaddress findById(int id) {
        String sql = "SELECT * FROM `shipaddress` WHERE `ID`= ?";
        return query(sql,new ShipaddressMapper(),id).get(0);
    }

    @Override
    public List<Shipaddress> getShipaddressBypage(int pagenum, int pagesize) {
        String sql = "SELECT * FROM `shipaddress` LIMIT ?,?";
        return query(sql, new ShipaddressMapper(),pagenum,pagesize);
    }
}
