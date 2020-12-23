package controller.DAO;

import model.Inventory;

public interface IInventory extends IBaseDAO<Inventory> {
    int saveInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
    void deleteInventory(int id);
    Inventory findById(int id);
}
