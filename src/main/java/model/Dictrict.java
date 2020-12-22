package model;

import java.io.Serializable;

public class Dictrict implements Serializable {
    private String NameDictrict;
    private String maqh;
    private String type;
    private String matp;

    public String getNameDictrict() {
        return NameDictrict;
    }

    public void setNameDictrict(String nameDictrict) {
        NameDictrict = nameDictrict;
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatp() {
        return matp;
    }

    public void setMatp(String matp) {
        this.matp = matp;
    }
}
