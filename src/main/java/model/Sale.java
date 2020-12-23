package model;

import java.io.Serializable;

public class Sale implements Serializable {
    private int idSale;
    private String nameSale;
    private int percent;

    public Sale(int idSale, String nameSale, int percent) {
        this.idSale = idSale;
        this.nameSale = nameSale;
        this.percent = percent;
    }

    public Sale(String nameSale, int percent) {
        this.nameSale = nameSale;
        this.percent = percent;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public String getNameSale() {
        return nameSale;
    }

    public void setNameSale(String nameSale) {
        this.nameSale = nameSale;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

}
