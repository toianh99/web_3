package model;

import java.io.Serializable;

public class Payment implements Serializable {
    private int idPayment;
    private String namePayment;
    private String type;
    private String desc;

    public Payment(String namePayment, String type, String desc) {
        this.namePayment = namePayment;
        this.type = type;
        this.desc = desc;
    }

    public Payment() {
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getNamePayment() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment = namePayment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
