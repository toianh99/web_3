package controller.DAO.Impl;

import controller.DAO.IInventory;
import controller.Mapper.Impl.InventoryMapper;
import model.Inventory;

public class InventoryDAOImpl extends BaseDAOImpl<Inventory> implements IInventory {
    @Override
    public int saveInventory(Inventory inventory) {
        StringBuilder sql = new StringBuilder("INSERT INTO `inventory`(`NameProduct`,`Quantity`,`PriceIn`,`Staff`)");
        sql.append(" VALUES(?, ?, ? , ?)");
        return insert(sql.toString(),inventory.getNameItem(),inventory.getQuantity(),inventory.getPriceIn(),inventory.getNameStaff());
    }

    @Override
    public void updateInventory(Inventory inventory) {
        StringBuilder sql = new StringBuilder("UPDATE `inventory` SET `NameProduct`= ? ,`Quantity`= ? ,`PriceIn` = ? , `Staff` = ? WHERE `ID`= ?");
        update(sql.toString(),inventory.getNameItem(),inventory.getQuantity(),inventory.getPriceIn(),inventory.getNameStaff(),inventory.getIdIventory());
    }

    @Override
    public void deleteInventory(int id) {
        String sql = " DELETE * FROM `inventory` WHERE `ID` = ? ";
        update(sql,id);
    }

    @Override
    public Inventory findById(int id) {
        String sql = "SELECT * FROM `inventory` WHERE `ID`= ?";
        return query(sql,new InventoryMapper(),id).get(0);
    }
}
