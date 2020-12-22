package model;

import java.io.Serializable;

public class Inventory implements Serializable {
    private int idIventory;
    private String nameItem;
    private String nameStaff;
    private int quantity;
    private int priceIn;

    public Inventory(String nameItem, String nameStaff, int quantity, int priceIn) {
        this.nameItem = nameItem;
        this.nameStaff = nameStaff;
        this.quantity = quantity;
        this.priceIn = priceIn;
    }

    public int getIdIventory() {
        return idIventory;
    }

    public void setIdIventory(int idIventory) {
        this.idIventory = idIventory;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(int priceIn) {
        this.priceIn = priceIn;
    }
}
