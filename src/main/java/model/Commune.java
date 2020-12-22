package model;

import java.io.Serializable;

public class Commune implements Serializable {
    private String NameCommune;
    private String type;
    private String maqh;

    public String getNameCommune() {
        return NameCommune;
    }

    public void setNameCommune(String nameCommune) {
        NameCommune = nameCommune;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
    }
}
