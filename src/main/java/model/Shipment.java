package model;

import java.io.Serializable;

public class Shipment implements Serializable {
    private int idShipment;
    private String nameShipment;
    private String typeShip ;

    public Shipment(int idShipment, String nameShipment, String typeShip) {
        this.idShipment = idShipment;
        this.nameShipment = nameShipment;
        this.typeShip = typeShip;
    }

    public Shipment(String nameShipment, String typeShip) {
        this.nameShipment = nameShipment;
        this.typeShip = typeShip;
    }

    public int getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(int idShipment) {
        this.idShipment = idShipment;
    }

    public String getNameShipment() {
        return nameShipment;
    }

    public void setNameShipment(String nameShipment) {
        this.nameShipment = nameShipment;
    }

    public String getTypeShip() {
        return typeShip;
    }

    public void setTypeShip(String typeShip) {
        this.typeShip = typeShip;
    }
}
