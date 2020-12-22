package model;

import java.io.Serializable;

public class Brand implements Serializable {
    private int idBrand;
    private String nameBrand;
    private String codeBrand;

    public Brand(String nameBrand, String codeBrand) {
        this.nameBrand = nameBrand;
        this.codeBrand = codeBrand;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getCodeBrand() {
        return codeBrand;
    }

    public void setCodeBrand(String codeBrand) {
        this.codeBrand = codeBrand;
    }
}
