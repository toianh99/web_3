package model;

import java.io.Serializable;

public class Shipaddress implements Serializable {
    private int idAddress;
    private String province;
    private String commune;
    private String dictrict;
    private String detail;

    public Shipaddress(int idAddress, String province, String commune, String dictrict, String detail) {
        this.idAddress = idAddress;
        this.province = province;
        this.commune = commune;
        this.dictrict = dictrict;
        this.detail = detail;
    }

    public Shipaddress(String province, String commune, String dictrict, String detail) {
        this.province = province;
        this.commune = commune;
        this.dictrict = dictrict;
        this.detail = detail;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDictrict() {
        return dictrict;
    }

    public void setDictrict(String dictrict) {
        this.dictrict = dictrict;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
