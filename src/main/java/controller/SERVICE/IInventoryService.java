package controller.SERVICE;

import model.Inventory;

public interface IInventoryService {
    int saveInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
    void deleteInventory(int id);
}
